package com.example.andres.laberinto_ecci;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andres on 8/07/2017.
 */

public class UsuariosBD extends SQLiteOpenHelper{

    String sqlCreate = "CREATE TABLE usuarios (user TEXT PRIMARY KEY, pass TEXT)";

    public UsuariosBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL(sqlCreate);

    }
}
