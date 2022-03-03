package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

            this.email = (EditText) findViewById(R.id.email);
            this.mdp = (EditText) findViewById(R.id.mdp);

            this.btncon = (Button) findViewById(R.id.btnconnexion);

        this.btncon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    recupmail= email.getText().toString();
                    recupmdp= mdp.getText().toString();

                    //jsondata="{\"email\":\""+recupmail+"\",\"mdp\":\""+recupmdp+"\"}";

                URL url;

                try {
                    url = new URL("http://192.168.43.2/all4sport/API/communication.php?email="+recupmail+"&mdp="+recupmdp);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Connexion.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

}