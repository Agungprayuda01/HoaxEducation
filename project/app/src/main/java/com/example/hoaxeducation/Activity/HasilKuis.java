package com.example.hoaxeducation.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hoaxeducation.MainActivity;
import com.example.hoaxeducation.R;

public class HasilKuis extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Jawaban benar : "+QuisActivity.benar+"\nJawaban Salah : "+QuisActivity.salah);
        nilai.setText(""+QuisActivity.hasil);
    }
    public void kembali(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
