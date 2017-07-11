package com.example.andres.laberinto_ecci;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Andres on 8/07/2017.
 */

//  Creamos clase Esfera heredando de la subclase ImageViw la cual nos permitira visualizar un archivo de imagen

public class Esfera extends ImageView {

    private int radio;
    private int posx;
    private int posy;
    int color;
    ShapeDrawable capa;
//Metodo en el cual definimos las variables de la esfera
    public Esfera(Context context, int radio, int posx, int posy) {
        super(context);
        this.setRadio(radio);
        this.setPosx(posx);
        this.setPosy(posy);
        color = Color.argb(100,100,0,100);
        capa = new ShapeDrawable(new OvalShape());
        capa.getPaint().setColor(color);
        capa.setBounds(posx-radio, posy-radio, posx+radio, posy+radio);
    }
//Metodo heredado de la clase en la cual pintamos la esfera
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        capa.setBounds(getPosx() - getRadio(), getPosy() - getRadio(), getPosx() + getRadio(), getPosy() + getRadio());
        capa.draw(canvas);
        invalidate();

    }
// Este metodo cambia las coordenadas en el lienzo
        public void move (int x, int y){
        setPosx(getPosx() + x);
        setPosy(getPosy() + y);
    }
// Encapsulamiento de variables

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
}

