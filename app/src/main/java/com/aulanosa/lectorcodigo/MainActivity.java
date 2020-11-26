package com.aulanosa.lectorcodigo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;

import androidx.annotation.Nullable;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    EditText txtResultado;
    Button btnEscanear, btnQr, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enlazar controles
        txtResultado = findViewById(R.id.txtResultado);
        btnEscanear = findViewById(R.id.btnEscanear);
        btnQr = findViewById(R.id.btnQR);
        btnSalir = findViewById(R.id.btnSalir);

        //quitar barra dentro del editext
        txtResultado.setInputType(InputType.TYPE_NULL);

        //Acción para el boton
        btnEscanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escanear();
            }
        });

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escanearQR();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    //Método para escanearQR

         public void escanearQR() {
            IntentIntegrator integrador = new IntentIntegrator(this);
            integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);

            integrador.setPrompt("Escanear Código");
            integrador.setCameraId(0);
            integrador.setBeepEnabled(true);
            integrador.setBarcodeImageEnabled(true);
            integrador.initiateScan();
        }
        //Método para escanearBarras
        public void escanear() {
            IntentIntegrator integrador = new IntentIntegrator(this);

            integrador.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);
            integrador.setPrompt("Escanear Código");
            integrador.setCameraId(0);
            integrador.setBeepEnabled(true);
            integrador.setBarcodeImageEnabled(true);
            integrador.initiateScan();
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult resultado =
                IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (resultado != null) {
            if (resultado.getContents() == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show();
            } else {
                txtResultado.setText(resultado.getContents().toString());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
