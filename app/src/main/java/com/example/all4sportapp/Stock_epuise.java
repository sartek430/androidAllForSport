package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Stock_epuise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_epuise);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<Produit> produits_epuise = new ArrayList<Produit>();

        String line = "";
        URL url;

        try {
            url = new URL("http://192.168.238.93/all4sport-master-api/API/produitEpuise.php");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            line = rd.readLine();
            System.out.println(line);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray article_epuises = new JSONArray();
        try {
            article_epuises = new JSONArray(line);
            for (int i = 0; i< article_epuises.length(); i++) {
                String nomProduit_epuise = article_epuises.getJSONObject(i).getString("nom");

                produits_epuise.add(new Produit(nomProduit_epuise, "0"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), produits_epuise));
    }
}