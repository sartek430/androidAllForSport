package com.example.all4sportapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ProduitAjout extends AppCompatActivity {
    //initialise variable
    Button btScan;
    Button btRefresh;
    Button btAjout;
    String resultat;
    String line;
    int quantite;
    EditText editAjouter;
    EditText editEtagere;
    EditText editSection;
    EditText editRangee;
    EditText editModule;
    int etagere;
    int section;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produitajout);

        //Assign variable
        btScan = findViewById(R.id.bt_scan);
        btRefresh = findViewById(R.id.button);
        btAjout = findViewById(R.id.button2);
        editAjouter = findViewById(R.id.editTextTextPersonName);
        editEtagere = findViewById(R.id.editTextTextPersonName2);
        editSection = findViewById(R.id.editTextTextPersonName6);
        editRangee = findViewById(R.id.editTextTextPersonName7);
        editModule = findViewById(R.id.editTextTextPersonName8);



        btScan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //Initialize intent integrator
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        ProduitAjout.this
                );
                //Set prompt text
                intentIntegrator.setPrompt("Pour utiliser le flash, appuyez sur le bouton volume haut");
                //Set beep
                intentIntegrator.setBeepEnabled(true);
                //Locked orientation
                intentIntegrator.setOrientationLocked(true);
                //Set capture activity
                intentIntegrator.setCaptureActivity(Capture.class);
                //Initiate scan
                intentIntegrator.initiateScan();
            }
        });

        btRefresh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProduitAjout.this, Localisation.class);
                startActivity(intent);
            }
        });

        btAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rangee = editRangee.getText().toString();
                String module = editModule.getText().toString();

                Context context = getApplicationContext();

                try {
                    String value= editAjouter.getText().toString();
                    int finalValue=Integer.parseInt(value);
                    String value1= editEtagere.getText().toString();
                    int finalValue1=Integer.parseInt(value1);
                    String value2= editSection.getText().toString();
                    int finalValue2=Integer.parseInt(value2);

                    quantite = finalValue;
                    etagere = finalValue1;
                    section = finalValue2;

                }catch (Exception e){
                    e.printStackTrace();
                    Toast toast = Toast.makeText(context, "Veuillez mettre un nombre", Toast.LENGTH_LONG);
                    toast.show();
                }


                URL url;

                try {
                    url = new URL("http://192.168.43.2/all4sport/API/gestionStock.php?reference="+resultat+"&entrepot="+resultat+"&quantite="+quantite);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    line = rd.readLine();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //Initialize intent result
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode,data
        );
        //Check condition
        if(intentResult.getContents() != null) {

            resultat= intentResult.getContents();
            //When result content is not null
            //Initialize alert dialog

            AlertDialog.Builder builder = new AlertDialog.Builder(
                    ProduitAjout.this
            );
            //Set title
            builder.setTitle("Result");
            //Set message
            builder.setMessage(intentResult.getContents());
            //Set positive button
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //Dismiss dialog
                    dialogInterface.dismiss();
                }
            });
            //show alert dialog
            builder.show();
        }else{
            //When result content is null
            //Display toast
            Toast.makeText(getApplicationContext(), "OOPS... Vous n'avez rien scanné", Toast.LENGTH_SHORT).show();
        }
    }

}
