package com.example.hoaxeducation.LihatBantuan;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoaxeducation.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {
    public TextView namab,masalahb,urlb;
    public CircularImageView image;


    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);

        namab = itemView.findViewById(R.id.namab);
        masalahb = itemView.findViewById(R.id.urlb);
        urlb = itemView.findViewById(R.id.masalahb);
        image = (CircularImageView) itemView.findViewById(R.id.imv);
    }
}
