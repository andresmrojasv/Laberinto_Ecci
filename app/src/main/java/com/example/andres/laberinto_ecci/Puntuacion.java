package com.example.andres.laberinto_ecci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Definimos la clase Principal donde declaramos variables para pasar la informacionn por las actividades
public class Puntuacion extends AppCompatActivity implements View.OnClickListener{

    Button regresar;


    // Metodo heredado el cual nos permite conectar  la vista con la clase para poder hacerla funcionar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);
        regresar = (Button) findViewById(R.id.BPRegresar);
        regresar.setOnClickListener(this);

    }

    // Metodo heredado que se llama cuando se hace click en la vista
    @Override
    public void onClick(View v) {

        Intent i= new Intent(this, Principal.class);
        startActivity(i);

    }
}
