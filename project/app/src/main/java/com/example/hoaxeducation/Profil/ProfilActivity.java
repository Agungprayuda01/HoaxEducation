package com.example.hoaxeducation.Profil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hoaxeducation.MainActivity;
import com.example.hoaxeducation.R;
import com.example.hoaxeducation.edit.EditActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfilActivity extends AppCompatActivity {
    TextView pname,puid,pemail;
    CircularImageView pimage;

    private RecyclerView recyclerView;
    private ArrayList<DataSetFire> arrayList;
    private FirebaseRecyclerOptions<DataSetFire> options;
    private FirebaseRecyclerAdapter<DataSetFire, FirebaseViewHolder> adapter;
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
        setContentView(R.layout.activity_profil);
        recyclerView = findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(ProfilActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        arrayList = new ArrayList<DataSetFire>();

        //inisialisasi
        pname = findViewById(R.id.profilnama);
        puid = findViewById(R.id.profiluid);
        pemail = findViewById(R.id.profilemail);
        pimage = findViewById(R.id.profilimage);

        //
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        //

        pemail.setText(currentUser.getEmail());
        pname.setText(currentUser.getDisplayName());
        puid.setText(currentUser.getUid());


        Glide.with(this).load(currentUser.getPhotoUrl()).into(pimage);
        pimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent waw = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(waw);
            }
        });

        //
        databasereference = FirebaseDatabase.getInstance().getReference("Berita");
        databasereference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<DataSetFire>().setQuery(databasereference,DataSetFire.class).build();
        adapter = new FirebaseRecyclerAdapter<DataSetFire, FirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int position, @NonNull DataSetFire model) {

                if(model.getProfilname().equals(currentUser.getDisplayName()) && model.getProfilemail().equals(currentUser.getEmail())){
                    holder.itemView.setVisibility(View.VISIBLE);
                }else {
                    ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
                    params.width = 0;
                    holder.itemView.setLayoutParams(params);
                }

//                holder.namab.setText(model.getPname());
                Picasso.get().load(model.getImage()).into(holder.image);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Intent = new Intent(ProfilActivity.this, Main4Activity.class);
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
                        final Dialog dialog = new Dialog(ProfilActivity.this);
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
                                        Intent Intent = new Intent(ProfilActivity.this, EditActivity.class);
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
                return new FirebaseViewHolder(LayoutInflater.from(ProfilActivity.this).inflate(R.layout.row2,ViewGroup,false));
            }
        };


        recyclerView.setAdapter(adapter);



    }
}
