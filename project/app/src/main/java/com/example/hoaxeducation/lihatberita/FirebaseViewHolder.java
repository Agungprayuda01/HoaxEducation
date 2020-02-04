package com.example.hoaxeducation.lihatberita;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoaxeducation.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {
    public TextView namab,catb,dateb,name;
    public ImageView image;
    public CircularImageView image1;


    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);

        namab = itemView.findViewById(R.id.namaberita);
        catb = itemView.findViewById(R.id.categoryberita);
        dateb = itemView.findViewById(R.id.dateberita);
        image = (ImageView) itemView.findViewById(R.id.imageViewberita);
        image1 =(CircularImageView) itemView.findViewById(R.id.imageVprofil);
        name = (TextView) itemView.findViewById(R.id.textVname);
    }
}
