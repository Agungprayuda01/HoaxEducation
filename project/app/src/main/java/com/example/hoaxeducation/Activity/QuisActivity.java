package com.example.hoaxeducation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoaxeducation.MainActivity;
import com.example.hoaxeducation.R;

public class QuisActivity extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton pilihanA, pilihanB, pilihanC, pilihanD;
    int nomor = 0;
    public static int hasil,benar,salah;

    String[] pertanyaan_kuis = new String[]{
            "1. Dibawah ini manakah Jenis konten hoax KECUALI?",
            "2. ketika informasi atau gambar yang asli sengaja dimanipulasi untuk menipu disebut?",
            "3. jenis konten yang memuat tentang segala usaha komersial disebut?",
            "4. Satire atau Parodi termasuk jenis?",
            "5. konten yang memuat segala hal yang berkaitan dengan keadaan sehat jasmani maupun rohani disebut?"
    };

    String[] jawaban_tersedia = new String[]{
            "agama","polotik","Kriminalitas","puisi",
            "konten youtube","Konten yang Dimanipulasi","Konten tiruan","Konten Menyesatkan",
            "bisnis","jualan","endorse","semua benar",
            "misinformasi dan disinformasi","misinformasi","jenis kasur","semua benar",
            "konten prank","kriminalitas","agama","kesehatan",
    };

    String[] jawaban_benar = new String[]{
      "puisi",
      "konten yang dimanipulasi",
      "bisnis",
      "misinformasi dan disinformasi",
      "kesehatan",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quis);

        rg = (RadioGroup)findViewById(R.id.Radio_Group);
        pertanyaan = (TextView) findViewById(R.id.pertanyaan);
        pilihanA = (RadioButton)findViewById(R.id.pilihanA);
        pilihanB = (RadioButton)findViewById(R.id.pilihanB);
        pilihanC = (RadioButton)findViewById(R.id.pilihanC);
        pilihanD = (RadioButton)findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        pilihanA.setText(jawaban_tersedia[0]);
        pilihanB.setText(jawaban_tersedia[1]);
        pilihanC.setText(jawaban_tersedia[2]);
        pilihanD.setText(jawaban_tersedia[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void Next(View view){
        if(pilihanA.isChecked()||pilihanB.isChecked()||pilihanC.isChecked()||pilihanD.isChecked()){
        RadioButton jawaban_user = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
        String ambil_jawaban_user = jawaban_user.getText().toString();
        rg.check(0);
        if(ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
        else salah++;
        nomor++;
        if(nomor<pertanyaan_kuis.length){
            pertanyaan.setText(pertanyaan_kuis[nomor]);
            pilihanA.setText(jawaban_tersedia[(nomor*4)+0]);
            pilihanB.setText(jawaban_tersedia[(nomor*4)+1]);
            pilihanC.setText(jawaban_tersedia[(nomor*4)+2]);
            pilihanD.setText(jawaban_tersedia[(nomor*4)+3]);
        } else{
            hasil = benar * 20;
            Intent selesai = new Intent(getApplicationContext(),HasilKuis.class);
            startActivity(selesai);
            }
        }else{
            Toast.makeText(this, "silahkan pili dulu",Toast.LENGTH_SHORT).show();
        }
    }
    public void kembaliq(View view){
        Intent kem = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(kem);
    }
    public void homeq(View view){
        Intent hom = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(hom);
    }
}
