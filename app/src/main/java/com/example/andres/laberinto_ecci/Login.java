package com.example.andres.laberinto_ecci;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Definimos la Login donde declaramos variables para pasar la informacionn por las actividades

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText usuario, contraseña; // Variables declaradas donde resiviremos los datos del usuario
    Button login, registrarse, salir, instrucciones;// Variables declaradas para capturar las acciones del usuario

    // Metodo heredado el cual nos permite conectar  la vista con la clase para poder hacerla funcionar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Recurso de diseño donde definimos la interfaz para el usuario
        GlobalTools.baseDeDatos = new UsuariosBD(this,"BDUsuarios",null,GlobalTools.bdVersion);
        usuario = (EditText) findViewById(R.id.ETLUsuario);//Declaracion de variable donde guardaremos los datos ingresados por el usuario
        contraseña = (EditText) findViewById(R.id.ETLContraseña);//Declaracion de variable donde guardaremos los datos ingresados por el usuario
        login = (Button) findViewById(R.id.BLIniciarSesion);//Declaracion de variable donde guardaremos las accion Iniciar Sesion

        login.setOnClickListener(this);
        registrarse = (Button) findViewById(R.id.BLRegistrarse);
        registrarse.setOnClickListener(this);
        salir = (Button) findViewById(R.id.BLSalir);
        salir.setOnClickListener(this);
        instrucciones = (Button) findViewById(R.id.BLinstrucciones);
        instrucciones.setOnClickListener(this);

    }

    // Metodo heredado que se llama cuando se hace click en la vista
    @Override
    public void onClick(View v) {

        if (v.equals(registrarse)){

            Intent i= new Intent(this, Registro.class);
            startActivity(i);

        }else if(v.equals(login)){

            SQLiteDatabase bd = GlobalTools.baseDeDatos.getReadableDatabase();
            Cursor cursor = bd.rawQuery("SELECT user, pass FROM usuarios WHERE user =?", new String[]{usuario.getText().toString()});

            if (cursor.moveToFirst()){

                String passG = cursor.getString(1);
                if(passG.equals(contraseña.getText().toString())){

                    Intent i= new Intent(this, Principal.class);
                    i.putExtra("user", usuario.getText().toString());
                    startActivity(i);

                }else{

                    Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_LONG).show();

                }

            }else{

                Toast.makeText(this, "Este usuario no esta registrado",Toast.LENGTH_LONG).show();
                contraseña.setText("");

            }

            cursor.close();
            bd.close();

        } if (v.equals(instrucciones)) {

            Intent i = new Intent(this, Instrucciones.class);
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
