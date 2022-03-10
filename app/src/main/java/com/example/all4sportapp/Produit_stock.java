package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

public class Produit_stock extends AppCompatActivity {

    private String produit;
    private int quantite;

    public Produit_stock(String produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public String getProduit() {
        return produit;
    }

    public int getQuantite() {
        return quantite;
    }
}
