package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SecondActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

                spinner = (Spinner) findViewById(R.id.ListeDeroulante);

                List All4sportlist = new ArrayList();
                All4sportlist.add("Accueil");
                All4sportlist.add("Localisation");
                All4sportlist.add("Caractéristique des produits");
                All4sportlist.add("ajout des produits");

                ArrayAdapter adapter = new ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item,
                        All4sportlist
                );

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

            }
    }

