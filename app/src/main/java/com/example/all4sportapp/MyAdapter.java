package com.example.all4sportapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Produit> produits;

    public MyAdapter(Context context, List<Produit> produits){
        this.context = context;
        this.produits = produits;
    }

    @NonNull

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.stock_view,parent,false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.nom_produitView.setText(produits.get(position).getArticle());
        holder.quantiteView.setText(produits.get(position).getQuantite());

    }

    public int getItemCount(){
        return produits.size();
    }

}
