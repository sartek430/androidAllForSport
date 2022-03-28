package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Menu extends AppCompatActivity {

    Button btnlocal;
    Button btnajoutprod;
    Button btnProduitEnstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.btnlocal = (Button) findViewById(R.id.btnLocalisation);

        this.btnlocal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Localisation.class);
                startActivity(intent);
            }
        });

        this.btnajoutprod = (Button) findViewById(R.id.btnAjoutProduit);

        this.btnajoutprod.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ProduitAjout.class);
                startActivity(intent);
            }
        });

        this.btnProduitEnstock = (Button) findViewById(R.id.btnProduitEnstock);

        this.btnProduitEnstock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Stock.class);
                startActivity(intent);
            }
        });

    }
}

