package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button btnlocal;
    Button btncaraprod;
    Button btnajoutprod;
    Button btnProduitEnstock;
    Spinner spinner;
    Spinner ListeDeroulante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.btnlocal = (Button) findViewById(R.id.btnLocalisation);

        this.btnlocal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, TroisiemeActivity.class);
                startActivity(intent);
            }
        });
       //this.btncaraprod = (Button) findViewById(R.id.btnCaractéristiqueProduit);

        //this.btncaraprod.setOnClickListener(new View.OnClickListener() {
           // public void onClick(View v) {
              //  Intent intent = new Intent(SecondActivity.this, QuatriemeActivity.class);
                //startActivity(intent);
            //}
        //});
        this.btnajoutprod = (Button) findViewById(R.id.btnAjoutProduit);

        this.btnajoutprod.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, CinquiemeActivity.class);
                startActivity(intent);
            }
        });

        this.btnProduitEnstock = (Button) findViewById(R.id.btnProduitEnstock);

        this.btnProduitEnstock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, SixiemeActivity.class);
                startActivity(intent);
            }
        });

    }
}

