package com.example.andres.laberinto_ecci;

import android.os.AsyncTask;

/**
 * Created by Andres on 8/07/2017.
 */

public class Cronometro extends AsyncTask <Void,Void,Integer> {

    private int minutos=0;
    private int segundos=0;
    private int totalSgs=0;

    private boolean activo = false;

    protected void onPreExecute(){
        activo=true;}

    @Override
    protected Integer doInBackground(Void... params) {
        while(isActivo()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            totalSgs++;
            minutos= totalSgs/60;
            segundos= totalSgs%60;
            GlobalTools.juego.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    GlobalTools.actualizarCronoView(minutos,segundos);

                }
            });

        }
        return totalSgs;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getTotalSgs() {
        return totalSgs;
    }

    public void setTotalSgs(int totalSgs) {
        this.totalSgs = totalSgs;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
