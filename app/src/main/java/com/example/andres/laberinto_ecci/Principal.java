package com.example.andres.laberinto_ecci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Definimos la clase Principal donde declaramos variables para pasar la informacionn por las actividades

public class Principal extends AppCompatActivity implements View.OnClickListener{

    TextView usuariologueado;
    Button  juego, puntuacion, creditos, cerrarsesion;


    // Metodo heredado el cual nos permite conectar  la vista con la clase para poder hacerla funcionar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        usuariologueado = (TextView) findViewById(R.id.TVPUsuario);
        usuariologueado.setText(this.getIntent().getStringExtra("user"));

        juego = (Button) findViewById(R.id.BPJuego);
        juego.setOnClickListener(this);
        puntuacion = (Button) findViewById(R.id.BPPuntuacion);
        puntuacion.setOnClickListener(this);
        creditos = (Button) findViewById(R.id.BPCreditos);
        creditos.setOnClickListener(this);
        cerrarsesion = (Button) findViewById(R.id.BPCerrarSesion);
        cerrarsesion.setOnClickListener(this);

    }

    // Metodo heredado que se llama cuando se hace click en la vista
    @Override
    public void onClick(View v) {

       if(v.equals(juego)){

            Intent i = new Intent(this, Juego.class);
            startActivity(i);

        }else if (v.equals(puntuacion)){

            Intent i= new Intent (this, Puntuacion.class);
            startActivity(i);

        }else if (v.equals(creditos)){

            Intent i = new Intent(this, Creditos.class);
            startActivity(i);

        }else if(v.equals(cerrarsesion)){

            Intent i= new Intent(this, Login.class);
            startActivity(i);

        }

    }
}
