package com.example.all4sportapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Stock extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<Produit> produits = new ArrayList<Produit>();



        URL url;
        String line = "";
        try {
            url = new URL("http://192.168.43.2/all4sport/API/produitStocke.php");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            line = rd.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Connexion BDD

        JSONArray articles = new JSONArray();
        try {
            articles = new JSONArray(line);
            for (int i = 0; i< articles.length(); i++) {
                String nom_produit = articles.getJSONObject(i).getString("nom");
                String quantite = articles.getJSONObject(i).getString("quantite_stock");

                produits.add(new Produit(nom_produit, quantite));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), produits));
    }}