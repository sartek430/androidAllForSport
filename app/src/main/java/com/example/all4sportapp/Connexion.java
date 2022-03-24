package com.example.all4sportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connexion extends AppCompatActivity {

    Button btncon;
    EditText email;
    EditText mdp;

    String line;
    String recupmail;
    String recupmdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

            this.email = (EditText) findViewById(R.id.email);
            this.mdp = (EditText) findViewById(R.id.mdp);

            this.btncon = (Button) findViewById(R.id.btnconnexion);

            Context context = getApplicationContext();

        this.btncon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    recupmail= email.getText().toString();
                    recupmail=recupmail.replaceFirst("@", "%40");
                    recupmdp= mdp.getText().toString();



                URL url;

                try {
                    url = new URL("http://192.168.43.86/all4sport/API/connexion.php?email="+recupmail+"&mdp="+recupmdp);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    line = rd.readLine();
                    System.out.println(line);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                if(line.equals("reussite")){

                    Intent intent = new Intent(Connexion.this, Menu.class);
                    startActivity(intent);

                }

                if(line.equals("echec")){

                    Toast toast = Toast.makeText(context, "Vérifiez votre login ou mot de passe", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });
    }

}