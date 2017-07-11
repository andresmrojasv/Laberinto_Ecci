package com.example.andres.laberinto_ecci;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Definimos la clase Creditos donde declaramos variables para pasar la informacionn por las actividades
public class Creditos extends AppCompatActivity implements View.OnClickListener{

    Button regresar;

    // Metodo heredado el cual nos permite conectar  la vista con la clase para poder hacerla funcionar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
        regresar = (Button) findViewById(R.id.BCRegresar);
        regresar.setOnClickListener(this);
    }

    // Metodo heredado que se llama cuando se hace click en la vista
    @Override
    public void onClick(View v) {

        Intent i= new Intent (this, Principal.class);
        startActivity(i);

    }
}
