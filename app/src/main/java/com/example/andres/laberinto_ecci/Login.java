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

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText usuario, contraseña;
    Button login, registrarse, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        GlobalTools.baseDeDatos = new UsuariosBD(this,"BDUsuarios",null,GlobalTools.bdVersion);
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

        }else if(v.equals(salir)){

            finish();
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);

        }

    }
}
