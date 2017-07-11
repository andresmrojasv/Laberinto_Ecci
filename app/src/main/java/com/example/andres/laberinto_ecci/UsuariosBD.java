package com.example.andres.laberinto_ecci;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andres on 8/07/2017.
 */
// Creamos la clase que nos permite crear la base datos
public class UsuariosBD extends SQLiteOpenHelper{

// Realizamos el query creando la tabla usuario

    String sqlCreate = "CREATE TABLE usuarios (user TEXT PRIMARY KEY, pass TEXT)";

    public UsuariosBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

//Metodo llamado cuando se crea la la base de datos por primera vaz creando filas y colunmnas
   @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);

    }

// Metodo heredado y llamado cuando la base de datos necesita mejoras o actualizaciones
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL(sqlCreate);

    }
}
