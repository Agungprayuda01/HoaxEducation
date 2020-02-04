package com.example.hoaxeducation.Profil;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoaxeducation.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {
//    public TextView namab;
    public ImageView image;


    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);

//        namab = itemView.findViewById(R.id.namaberita3);
        image = (ImageView) itemView.findViewById(R.id.imageViewberita3);
    }
}
