package com.example.hoaxeducation.LihatBantuan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hoaxeducation.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataSetFire> arrayList;
    private FirebaseRecyclerOptions<DataSetFire> options;
    private FirebaseRecyclerAdapter<DataSetFire,FirebaseViewHolder> adapter;
    private DatabaseReference databasereference,daa;

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<DataSetFire>();
        databasereference = FirebaseDatabase.getInstance().getReference().child("bantuan");
        databasereference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<DataSetFire>().setQuery(databasereference,DataSetFire.class).build();

        adapter = new FirebaseRecyclerAdapter<DataSetFire, FirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int position, @NonNull DataSetFire model) {

                holder.namab.setText(model.getNamaberita());
                holder.masalahb.setText(model.getMasaalah());
                holder.urlb.setText(model.getEmail());
                Picasso.get().load(model.getProfilimage()).into(holder.image);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Intent = new Intent(HomeActivity.this, Main2Activity.class);
                        Intent.putExtra("namaberita",model.getNamaberita());
                        Intent.putExtra("masaalah",model.getMasaalah());
                        Intent.putExtra("url", model.getUrl());
                        startActivity(Intent);
                    }
                });

            }

            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int  i) {
                return new FirebaseViewHolder(LayoutInflater.from(HomeActivity.this).inflate(R.layout.row,ViewGroup,false));
            }
        };


        recyclerView.setAdapter(adapter);



    }
}
