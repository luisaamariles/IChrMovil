package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 24/10/2016.
 */
public class List2 {
    private String nombre;
    private int drawableImageID;

    public List2(String nombre, int drawableImageID) {
        this.nombre = nombre;
        this.drawableImageID = drawableImageID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDrawableImageID() {
        return drawableImageID;
    }

    public void setDrawableImageID(int drawableImageID) {
        this.drawableImageID = drawableImageID;
    }
}
