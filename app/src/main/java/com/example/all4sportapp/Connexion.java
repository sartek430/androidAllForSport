package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class Connexion extends AppCompatActivity {

    Button btncon;
    EditText email;
    EditText mdp;

    String jsondata;
    String recupmail;
    String recupmdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            this.email = (EditText) findViewById(R.id.email);
            this.mdp = (EditText) findViewById(R.id.mdp);

            this.btncon = (Button) findViewById(R.id.btnconnexion);

        this.btncon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    recupmail= email.getText().toString();
                    recupmdp= mdp.getText().toString();

                    jsondata="{\"email\":\""+recupmail+"\",\"mdp\":\""+recupmdp+"\"}";


                Intent intent = new Intent(Connexion.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    
}