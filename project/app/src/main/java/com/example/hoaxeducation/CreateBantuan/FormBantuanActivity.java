package com.example.hoaxeducation.CreateBantuan;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormBantuanActivity extends AppCompatActivity {
    private DatabaseReference database;
    private Button btSubmit;
    private EditText etnama;
    private EditText etemail;
    private EditText eturl;
    private EditText etmasalah;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_bantuan);

        //
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        // inisialisasi fields EditText dan Button
        etnama = (EditText) findViewById(R.id.et_namaberita);
        etemail = (EditText) findViewById(R.id.et_email);
        eturl = (EditText) findViewById(R.id.et_url);
        etmasalah = (EditText) findViewById(R.id.et_masalah);
        btSubmit = (Button) findViewById(R.id.bt_submit);
        String image = new String(currentUser.getPhotoUrl().toString());
        etemail.setText(currentUser.getEmail());
        etemail.setEnabled(false);

        database = FirebaseDatabase.getInstance().getReference();

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty(etnama.getText().toString()) && !isEmpty(etemail.getText().toString()) && !isEmpty(eturl.getText().toString()) && !isEmpty(etmasalah.getText().toString()))
                    submitBantuan(new impBantuan(etnama.getText().toString(), etemail.getText().toString(), eturl.getText().toString(), etmasalah.getText().toString(),image));
                else
                    Snackbar.make(findViewById(R.id.bt_submit), "Data form tidak boleh kosong", Snackbar.LENGTH_LONG).show();

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

    private void submitBantuan(impBantuan impBantuan) {
        database.child("bantuan").push().setValue(impBantuan).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etnama.setText("");
                etemail.setText("");
                eturl.setText("");
                etmasalah.setText("");
                Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil dikirim", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, FormBantuanActivity.class);
    }
}
