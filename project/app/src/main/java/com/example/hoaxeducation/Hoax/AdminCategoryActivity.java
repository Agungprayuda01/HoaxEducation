package com.example.hoaxeducation.Hoax;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hoaxeducation.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminCategoryActivity extends AppCompatActivity
{
    private ImageView tShirts, sportsTShirts;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);


        tShirts = (ImageView) findViewById(R.id.t_shirts);
        sportsTShirts = (ImageView) findViewById(R.id.sports_t_shirts);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Hoax");
                intent.putExtra("profilname",currentUser.getDisplayName());
                intent.putExtra("profilimage",currentUser.getPhotoUrl().toString());
                intent.putExtra("profilemail",currentUser.getEmail());
                startActivity(intent);
            }
        });


        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Bukan Hoax");
                intent.putExtra("profilname",currentUser.getDisplayName());
                intent.putExtra("profilimage",currentUser.getPhotoUrl().toString());
                intent.putExtra("profilemail",currentUser.getEmail());
                startActivity(intent);
            }
        });
    }
}

