package com.example.all4sportapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter_epuise extends RecyclerView.Adapter<MyViewHolder_epuise> {
    Context context;
    List<Produit_epuise> produit_epuises;

    public MyAdapter_epuise(Context context, List<Produit_epuise> produit_epuises){
        this.context = context;
        this.produit_epuises = produit_epuises;
    }

    @NonNull

    public MyViewHolder_epuise onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new MyViewHolder_epuise(LayoutInflater.from(context).inflate(R.layout.stock_epuise_view,parent,false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder_epuise holder, int position){
        holder.nomProduitEpuiseView.setText(produit_epuises.get(position).getArticle_epuise());
        holder.quantiteEpuiseView.setText(produit_epuises.get(position).getQuantite_epuise());

    }

    public int getItemCount(){
        return produit_epuises.size();
    }

}
