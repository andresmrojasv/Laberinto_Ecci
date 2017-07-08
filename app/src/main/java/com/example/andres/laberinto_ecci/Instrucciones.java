package com.example.andres.laberinto_ecci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instrucciones extends AppCompatActivity implements View.OnClickListener{

    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);
        regresar = (Button) findViewById(R.id.BIRegresar);
        regresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i= new Intent (this, Principal.class);
        startActivity(i);

    }
}
