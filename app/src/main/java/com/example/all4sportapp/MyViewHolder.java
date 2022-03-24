package com.example.all4sportapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nom_produitView, quantiteView;

    public MyViewHolder(@NonNull View itemView){
        super (itemView);
        nom_produitView = itemView.findViewById(R.id.article);
        quantiteView = itemView.findViewById(R.id.quantite);
    }
}
