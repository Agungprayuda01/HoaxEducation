package com.example.hoaxeducation.tentang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hoaxeducation.CreateLaporan.FormLaporanActivity;
import com.example.hoaxeducation.R;

public class Tentang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
    }

    public void laporkan(View view) {
        Intent bug = new Intent(Tentang.this, FormLaporanActivity.class);
        startActivity(bug);
    }
}
