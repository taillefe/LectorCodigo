package com.aulanosa.lectorcodigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Portada extends AppCompatActivity {

    TextView mensaje;
    ImageView imagenportada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        //OCULTAMOS TÍTULO
       getSupportActionBar().hide();

        //Imagen se muestre unos segundos y pase a otra pantalla
        super.onStart();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Portada.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }, 4000);


        mensaje=(TextView) findViewById(R.id.mensaje);
        mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //no hace nada cuando pulsa
            }
        });

    /*    imagenportada =(ImageView)findViewById(R.id.imagenportada);

        imagenportada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambioVentana = new Intent(Portada.this,MainActivity.class);
                startActivity(cambioVentana);
            }
        });
*/
    }

}
