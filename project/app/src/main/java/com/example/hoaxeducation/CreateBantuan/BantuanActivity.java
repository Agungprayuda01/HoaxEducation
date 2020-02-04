package com.example.hoaxeducation.CreateBantuan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hoaxeducation.LihatBantuan.HomeActivity;
import com.example.hoaxeducation.R;

public class BantuanActivity extends AppCompatActivity {
    private Button btCreateDB;
    private Button btViewDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);
        //inisialisasibantuan
        btCreateDB = (Button) findViewById(R.id.bt_createdata);
        btViewDB = (Button) findViewById(R.id.bt_viewdata);

        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(FormBantuanActivity.getActIntent(BantuanActivity.this));
            }
        });

        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bantuan = new Intent(BantuanActivity.this, HomeActivity.class);
                startActivity(bantuan);
            }
        });

    }

}
