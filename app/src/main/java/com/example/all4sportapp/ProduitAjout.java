package com.example.all4sportapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ProduitAjout extends AppCompatActivity {
    //initialise variable
    Button btScan;
    Button btRefresh;
    Button btAjout;
    int resultat;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produitajout);

        //Assign variable
        btScan = findViewById(R.id.bt_scan);
        btRefresh = findViewById(R.id.button);
        btAjout = findViewById(R.id.button2);

        btAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

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

            resultat= Integer.parseInt(intentResult.getContents());
            System.out.println(resultat);
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
