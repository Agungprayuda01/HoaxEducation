package com.example.hoaxeducation.Profil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hoaxeducation.CreateBugs.FormReportActivity;
import com.example.hoaxeducation.R;
import com.squareup.picasso.Picasso;

public class Main4Activity extends AppCompatActivity {
    TextView judul,nama1,date1,deskripsi1,katagori;
    EditText pid1;
    ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        String pname = getIntent().getStringExtra("pname");
        String pid = getIntent().getStringExtra("pid");
        String date = getIntent().getStringExtra("date");
        String category = getIntent().getStringExtra("category");
        String image = getIntent().getStringExtra("image");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String nama = getIntent().getStringExtra("prace");
        Log.i("OUR VALUE",pname);
        Log.i("OUR VALUE 2",date);
        Log.i("OUR VALUE 3",category);
        Log.i("OUR VALUE 4",image);
        Log.i("OUR VALUE 5",deskripsi);
        Log.i("OUR VALUE 6",nama);
        Log.i("OUR VALUE",pid);
        Toast.makeText(this,""+pname, Toast.LENGTH_SHORT).show();
        //inisialisasi
        image1 = (ImageView) findViewById(R.id.imageberita2);
        judul = (TextView) findViewById(R.id.judulberita);
        nama1 = (TextView) findViewById(R.id.namapenulis);
        date1 = findViewById(R.id.date);
        katagori = findViewById(R.id.katagoriberita);
        deskripsi1 = findViewById(R.id.deskripsi);
        pid1 = (EditText) findViewById(R.id.pidberita);
        //implements
        Picasso.get().load(image).into(image1);
        judul.setText(pname);
        nama1.setText(nama);
        date1.setText(date);
        katagori.setText(category);
        deskripsi1.setText(deskripsi);
        pid1.setText(pid);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detail = getIntent().getStringExtra("image");
                Intent intent = new Intent(Main4Activity.this, WebviewActivity.class);
                intent.putExtra("detailimage", detail);
                startActivity(intent);
            }
        });
    }

    public void report(View view) {
        String email = getIntent().getStringExtra("profilemail");
        String uid = getIntent().getStringExtra("pid");
        Intent report = new Intent(Main4Activity.this, FormReportActivity.class);
        report.putExtra("email", email);
        report.putExtra("uid",uid);
        startActivity(report);
    }
}
