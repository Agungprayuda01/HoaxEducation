package com.example.hoaxeducation.CreateBugs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.hoaxeducation.CreateBantuan.FormBantuanActivity;
import com.example.hoaxeducation.CreateBantuan.impBantuan;
import com.example.hoaxeducation.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormReportActivity extends AppCompatActivity {
    EditText uid,email,masalah;
    Button submit;
    private DatabaseReference database;
    String semail,suid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_report);

        //getstirng
        semail = getIntent().getStringExtra("email");
        suid = getIntent().getStringExtra("uid");
        //inisialisasi
        uid = findViewById(R.id.uidberita);
        email = findViewById(R.id.emailberita);
        masalah = findViewById(R.id.masalahberita);
        submit = findViewById(R.id.button11);
        //settext
        email.setText(semail);
        uid.setText(suid);
        //settingtextbox
        email.setEnabled(false);
        uid.setEnabled(false);
        //setfirebasedatabase
        database = FirebaseDatabase.getInstance().getReference();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty(uid.getText().toString()) && !isEmpty(email.getText().toString()) && !isEmpty(masalah.getText().toString()))
                    submitBug(new impbugs(uid.getText().toString(), email.getText().toString(), masalah.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.bt_submit), "tuliskan permasalahannya", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        email.getWindowToken(), 0);
            }
        });
    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void submitBug(impbugs impbugs) {
        database.child("report").push().setValue(impbugs).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                uid.setText(semail);
                email.setText(suid);
                masalah.setText("");
                Snackbar.make(findViewById(R.id.button11), "Berita berhasil direport", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, FormReportActivity.class);
    }
}
