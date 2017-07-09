package com.example.andres.laberinto_ecci;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
import static com.example.andres.laberinto_ecci.GlobalTools.juego;

public class Juego extends AppCompatActivity implements SensorEventListener {

    private TextView crono;

    private SensorManager sensorManager;
    private Sensor acelerometro;
    private long ultimaActualizacion;
    private Esfera bolita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        setCrono ((TextView) findViewById(R.id.TVJCronometro));
        juego = this;
        GlobalTools.miCronometro = new Cronometro();
        GlobalTools.miCronometro.execute();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ultimaActualizacion = System.currentTimeMillis();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels; //ancho absoluto en pixels
        int height = metrics.heightPixels;//alto absoluto en pixels

        bolita = new Esfera(this, width/40, width/40, width/40);
        setContentView(bolita);
    }

    public TextView getCrono() {
        return crono;
    }

    public void setCrono(TextView crono) {
        this.crono = crono;
    }

    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_GAME);
    }

    protected  void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels; //ancho absoluto en pixels
        int height = metrics.heightPixels;//alto absoluto en pixels
        int radio = width/40;

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER ) {

            if (bolita.getPosx() >= (width - radio)) {
                // Toast.makeText(this, "cordenada x der" + bolita.getPosx(), Toast.LENGTH_SHORT).show();
                bolita.move(-1, 0);

            } else if (bolita.getPosx() <= radio) {
                //Toast.makeText(this, "cordenada x izq" + bolita.getPosx(), Toast.LENGTH_SHORT).show();
                bolita.move(1, 0);
            } else if (bolita.getPosy() <= radio) {
                //Toast.makeText(this, "cordenada y arriba" + bolita.getPosy(), Toast.LENGTH_SHORT).show();
                bolita.move(0, 2);

            } else if (bolita.getPosy() >= (height - radio)) {
                //Toast.makeText(this, "cordenada y abajo " + bolita.getPosy(), Toast.LENGTH_SHORT).show();
                bolita.move(0, -2);

            } else {
                bolita.move((int) -event.values[0], (int) event.values[1]);
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}