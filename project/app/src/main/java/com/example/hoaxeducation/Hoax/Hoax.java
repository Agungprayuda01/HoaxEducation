package com.example.hoaxeducation.Hoax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hoaxeducation.R;
import com.example.hoaxeducation.lihatberita.HomeActivity;

public class Hoax extends AppCompatActivity {
    private Button btViewDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoax);
        btViewDB = (Button) findViewById(R.id.button2);
        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent txc = new Intent(Hoax.this, HomeActivity.class);
                startActivity(txc);
            }
        });
    }

   // public void lihatberita(View view) {
     //   Intent lihatb = new Intent(Hoax.this, DisplayImagesActivity.class);
       // startActivity(lihatb);
   //}

    public void inputberita(View view) {
        Intent bantuan = new Intent(Hoax.this, AdminCategoryActivity.class);
        startActivity(bantuan);
    }
}
