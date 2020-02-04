package com.example.hoaxeducation.CreateLaporan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hoaxeducation.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormLaporanActivity extends AppCompatActivity {
    private DatabaseReference database;
    private Button btSubmit;
    private EditText etnama;
    private EditText etemail;
    private EditText etfitur;
    private EditText etmasalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_laporan);

        // inisialisasi fields EditText dan Button
        etnama = (EditText) findViewById(R.id.et_namaberita1);
        etemail = (EditText) findViewById(R.id.et_email1);
        etfitur = (EditText) findViewById(R.id.et_url1);
        etmasalah = (EditText) findViewById(R.id.et_masalah1);
        btSubmit = (Button) findViewById(R.id.bt_submit1);

        database = FirebaseDatabase.getInstance().getReference();

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty(etnama.getText().toString()) && !isEmpty(etemail.getText().toString()) && !isEmpty(etfitur.getText().toString()) && !isEmpty(etmasalah.getText().toString()))
                    submitlaporan(new impBugs(etnama.getText().toString(), etemail.getText().toString(), etfitur.getText().toString(), etmasalah.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.bt_submit1), "Data form tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etnama.getWindowToken(), 0);
            }
        });
    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void submitlaporan(impBugs impBugs) {
        database.child("Bugs").push().setValue(impBugs).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etnama.setText("");
                etemail.setText("");
                etfitur.setText("");
                etmasalah.setText("");
                Snackbar.make(findViewById(R.id.bt_submit1), "Data berhasil dikirim", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, FormLaporanActivity.class);
    }
}
