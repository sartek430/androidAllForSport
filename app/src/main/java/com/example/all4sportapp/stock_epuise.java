package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class stock_epuise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_epuise);

        String line;
        URL url;

        try {
            url = new URL("http://192.168.43.2/all4sport/API/produitEpuise.php");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            line = rd.readLine();
            System.out.println(line);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}