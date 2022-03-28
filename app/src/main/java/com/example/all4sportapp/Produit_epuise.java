package com.example.all4sportapp;

public class Produit_epuise {

    public Produit_epuise(String article_epuise, String quantite_epuise) {
        this.article_epuise = article_epuise;
        this.quantite_epuise = quantite_epuise;
    }

    public String getArticle_epuise() {
        return article_epuise;
    }

    public void setArticle_epuise(String article_epuise) {
        this.article_epuise = article_epuise;
    }

    public String getQuantite_epuise() {
        return quantite_epuise;
    }

    public void setQuantite_epuise(String quantite_epuise) {
        this.quantite_epuise = quantite_epuise;
    }

    String article_epuise;
    String quantite_epuise;
}
