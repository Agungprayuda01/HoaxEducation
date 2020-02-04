package com.example.hoaxeducation.lihatberita;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoaxeducation.R;
import com.example.hoaxeducation.edit.EditActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataSetFire> arrayList;
    private FirebaseRecyclerOptions<DataSetFire> options;
    private FirebaseRecyclerAdapter<DataSetFire,FirebaseViewHolder> adapter;
    private DatabaseReference databasereference,daa;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
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
        setContentView(R.layout.activity_home1);
        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<DataSetFire>();

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        databasereference = FirebaseDatabase.getInstance().getReference("Berita");
        databasereference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<DataSetFire>().setQuery(databasereference,DataSetFire.class).build();

        adapter = new FirebaseRecyclerAdapter<DataSetFire, FirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int position, @NonNull DataSetFire model) {

//                if(model.getProfilname().equals(currentUser.getDisplayName()) && model.getProfilemail().equals(currentUser.getEmail())){
//
//                }else {
//                    ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
//                    params.height = 0;
//                    holder.itemView.setLayoutParams(params);
//                }

                holder.namab.setText(model.getPname());
                holder.dateb.setText(model.getDate());
                holder.catb.setText(model.getCategory());
                holder.name.setText(model.getProfilname());
                Picasso.get().load(model.getImage()).into(holder.image);
                Picasso.get().load(model.getProfilimage()).into(holder.image1);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Intent = new Intent(HomeActivity.this, Main4Activity.class);
                        Intent.putExtra("pname",model.getPname());
                        Intent.putExtra("date",model.getDate());
                        Intent.putExtra("category", model.getCategory());
                        Intent.putExtra("image",model.getImage());
                        Intent.putExtra("prace",model.getPrice());
                        Intent.putExtra("time",model.getTime());
                        Intent.putExtra("deskripsi",model.getDescription());
                        Intent.putExtra("profilemail",model.getProfilemail());
                        Intent.putExtra("pid",model.getPid());
                        startActivity(Intent);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        final Dialog dialog = new Dialog(HomeActivity.this);
                        dialog.setContentView(R.layout.dialog_view);
                        dialog.setTitle("Pilih Aksi");
                        dialog.show();
                        Button editButton = (Button) dialog.findViewById(R.id.bt_edit_data);
                        Button delButton = (Button) dialog.findViewById(R.id.bt_delete_data);
                        editButton.setEnabled(false);
                        delButton.setEnabled(false);
                        if(model.getProfilname().equals(currentUser.getDisplayName()) && model.getProfilemail().equals(currentUser.getEmail())){
                            editButton.setEnabled(true);
                            delButton.setEnabled(true);
                        }else {
                            editButton.setEnabled(false);
                            delButton.setEnabled(false);
                        }

                        editButton.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialog.dismiss();
                                        Intent Intent = new Intent(HomeActivity.this, EditActivity.class);
                                        Intent.putExtra("pname",model.getPname());
                                        Intent.putExtra("date",model.getDate());
                                        Intent.putExtra("category", model.getCategory());
                                        Intent.putExtra("image",model.getImage());
                                        Intent.putExtra("prace",model.getPrice());
                                        Intent.putExtra("time",model.getTime());
                                        Intent.putExtra("deskripsi",model.getDescription());
                                        Intent.putExtra("profilemail",model.getProfilemail());
                                        Intent.putExtra("pid",model.getPid());
                                        startActivity(Intent);
                                    }
                                }
                        );

                        delButton.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        daa = FirebaseDatabase.getInstance().getReference()
                                                .child("Berita").child(model.getPid());
                                        daa.removeValue();
                                        dialog.dismiss();
                                    }
                                }
                        );
                        return true;
                    }
                });
            }

            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int  i) {
                return new FirebaseViewHolder(LayoutInflater.from(HomeActivity.this).inflate(R.layout.row1,ViewGroup,false));
            }
        };


        recyclerView.setAdapter(adapter);



    }
}

