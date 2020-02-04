package com.example.hoaxeducation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hoaxeducation.Activity.QuisActivity;
import com.example.hoaxeducation.CreateBantuan.BantuanActivity;
import com.example.hoaxeducation.CreateLaporan.FormLaporanActivity;
import com.example.hoaxeducation.Hoax.AdminCategoryActivity;
import com.example.hoaxeducation.Hoax.Hoax;
import com.example.hoaxeducation.Profil.ProfilActivity;
import com.example.hoaxeducation.login.LoginActivity;
import com.example.hoaxeducation.pembelajaran.PembelajaranActivity;
import com.example.hoaxeducation.tentang.Tentang;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth Auth;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void quism(View view) {
        Intent Intent = new Intent(MainActivity.this,  QuisActivity.class);
        startActivity(Intent);
    }

    public void bantuan(View view) {
        Intent bantuan = new Intent(MainActivity.this, BantuanActivity.class);
        startActivity(bantuan);
    }
    public void hoax(View view) {
        Intent hoax = new Intent(MainActivity.this, Hoax.class);
        startActivity(hoax);
    }
    public void laporan(View view){
        Intent laporan = new Intent(MainActivity.this, FormLaporanActivity.class);
        startActivity(laporan);
    }

    public void keluar(View view) {
        Auth.getInstance().signOut();
        Intent kela = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(kela);
        finish();
    }

    public void profil(View view) {
        Intent profil = new Intent(MainActivity.this , ProfilActivity.class);
        startActivity(profil);
    }

    public void tentang(View view) {
        Intent tent = new Intent(MainActivity.this, Tentang.class);
        startActivity(tent);
    }

    public void pembelajaran(View view) {
        Intent pembelajaran = new Intent(MainActivity.this, PembelajaranActivity.class);
        startActivity(pembelajaran);
    }
}
