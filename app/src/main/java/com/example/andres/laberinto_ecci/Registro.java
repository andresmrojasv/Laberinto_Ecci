package com.example.andres.laberinto_ecci;


import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener{

    Button registrar, regresar;
    EditText usuario, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario = (EditText) findViewById(R.id.ETRUsuario);
        contraseña = (EditText) findViewById(R.id.ETRContraseña);
        registrar = (Button) findViewById(R.id.BRRegistrar);
        registrar.setOnClickListener(this);
        regresar = (Button) findViewById(R.id.BRRegresar);
        regresar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.equals(registrar)){
            SQLiteDatabase db= GlobalTools.baseDeDatos.getWritableDatabase();
            String sqlinsert = "INSERT INTO usuarios (user, pass) VALUES ('"+
                    usuario.getText().toString()+"','"+contraseña.getText().toString()+"')";

            if(db !=null){

                try{
                    db.execSQL(sqlinsert);
                }catch (SQLiteConstraintException e){
                    Toast.makeText(this, "Este usuario ya existe en la BD",Toast.LENGTH_LONG).show();
                }
            }

            db.close();
            Intent i= new Intent(this, Principal.class);
            startActivity(i);
            Toast.makeText(this,"Usuario Registrado Correctamente", Toast.LENGTH_LONG).show();

        }else if(v.equals(regresar)){
            Intent i= new Intent(this, Login.class);
            startActivity(i);
        }

    }
}
