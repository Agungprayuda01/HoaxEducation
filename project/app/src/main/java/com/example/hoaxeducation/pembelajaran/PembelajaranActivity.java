package com.example.hoaxeducation.pembelajaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hoaxeducation.R;

public class PembelajaranActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelajaran);

        btn1 = findViewById(R.id.button12);
        btn2 = findViewById(R.id.button13);
        btn3 = findViewById(R.id.button14);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materi1 = new Intent(PembelajaranActivity.this,Materi1Activity.class);
                startActivity(materi1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materi2 = new Intent(PembelajaranActivity.this,Materi2Activity.class);
                startActivity(materi2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materi3 = new Intent(PembelajaranActivity.this,Materi3Activity.class);
                startActivity(materi3);
            }
        });
    }
}
