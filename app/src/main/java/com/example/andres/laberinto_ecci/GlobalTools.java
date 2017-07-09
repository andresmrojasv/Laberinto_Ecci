package com.example.andres.laberinto_ecci;

/**
 * Created by Andres on 8/07/2017.
 */

public class GlobalTools {

    public static UsuariosBD baseDeDatos;
    public static final int bdVersion = 1;
    public static Juego juego;
    public static Cronometro miCronometro;

    public static void actualizarCronoView(int mins, int secs){

        juego.getCrono().setText(mins+":"+secs);

    }


}
