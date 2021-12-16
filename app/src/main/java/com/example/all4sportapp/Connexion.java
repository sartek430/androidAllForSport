package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Connexion extends AppCompatActivity {

    Button btncon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            this.btncon = (Button) findViewById(R.id.btnconnexion);

        this.btncon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Connexion.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}