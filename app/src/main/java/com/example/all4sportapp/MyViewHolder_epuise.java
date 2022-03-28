package com.example.all4sportapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder_epuise extends RecyclerView.ViewHolder {

    TextView nomProduitEpuiseView, quantiteEpuiseView;

    public MyViewHolder_epuise(@NonNull View itemView){
        super (itemView);
        nomProduitEpuiseView = itemView.findViewById(R.id.article_epuise);
        quantiteEpuiseView = itemView.findViewById(R.id.quantite_epuise);
    }
}
