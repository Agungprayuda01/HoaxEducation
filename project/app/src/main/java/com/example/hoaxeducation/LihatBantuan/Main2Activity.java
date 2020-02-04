package com.example.hoaxeducation.LihatBantuan;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hoaxeducation.R;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String namaberita = getIntent().getStringExtra("namaberita");
        String masaalah = getIntent().getStringExtra("masaalah");
        String url = getIntent().getStringExtra("url");
        int getStringFromEdittext = getIntent().getExtras().getInt("url");
        Log.i("OUR VALUE",namaberita);
        Log.i("OUR VALUE 2",masaalah);
        //Log.i("OUR VALUE 3",url);
        Toast.makeText(this,""+namaberita, Toast.LENGTH_SHORT).show();

        //
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        url = url.replace("https://","");
        webView.loadUrl("https://"+url);
    }
}
