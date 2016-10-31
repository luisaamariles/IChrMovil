package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 30/10/2016.
 */
public class ListCons {
    private String nombre;
    private String promo;

    public ListCons(String nombre, String promo) {
        this.nombre = nombre;
        this.promo = promo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPromo() {
        return promo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }
}
