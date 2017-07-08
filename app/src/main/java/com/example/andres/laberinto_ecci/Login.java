package com.example.andres.laberinto_ecci;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText usuario, contraseña;
    Button login, registrarse, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (EditText) findViewById(R.id.ETLUsuario);
        contraseña = (EditText) findViewById(R.id.ETLContraseña);
        login = (Button) findViewById(R.id.BLIniciarSesion);
        login.setOnClickListener(this);
        registrarse = (Button) findViewById(R.id.BLRegistrarse);
        registrarse.setOnClickListener(this);
        salir = (Button) findViewById(R.id.BLSalir);
        salir.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v.equals(registrarse)){

            Intent i= new Intent(this, Registro.class);
            startActivity(i);

        }else if(v.equals(login)){

            //TODO conección a la BD para el logueo

            //Logueo de admin para probar


                Intent i= new Intent(this, Principal.class);
                i.putExtra("user", usuario.getText().toString());
                startActivity(i);

        }else if(v.equals(salir)){

            finish();
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);

        }

    }
}
