package com.example.all4sportapp;

public class Produit {
    String article,quantite;

    public Produit(String article,String quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}