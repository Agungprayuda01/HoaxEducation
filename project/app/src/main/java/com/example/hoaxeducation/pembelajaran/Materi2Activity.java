package com.example.hoaxeducation.pembelajaran;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.hoaxeducation.R;

public class Materi2Activity extends AppCompatActivity {

    private static final String VIDEO_URL = "https://firebasestorage.googleapis.com/v0/b/hoaxeducation.appspot.com/o/Percussion%20Show%20(FREE%20MUSIC)%20-%20Igor%20Khainskyi%20%5BRelease%20Trailer%5D.mp4?alt=media&token=5d43607e-5d24-4d12-a5b6-ac9da1ae45cc";

    ProgressDialog pDialog;
    VideoView videoView;
    MediaController mediaController;
    Uri video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi2);

        videoView = (VideoView) findViewById(R.id.video_view);

        videoStream();

    }

    private void videoStream() {
        // membuat progressbar
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Buffering ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        try {
            // Memulai MediaController
            mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            // Video URL
            video = Uri.parse(VIDEO_URL);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(video);
            videoView.requestFocus();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                // Menutup pDialog dan play video
                public void onPrepared(MediaPlayer mp) {
                    pDialog.dismiss();
                    videoView.start();
                }
            });
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
    }

}