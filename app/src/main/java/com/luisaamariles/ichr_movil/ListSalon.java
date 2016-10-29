package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 24/10/2016.
 */
public class ListSalon {
    private String nombre;
    private String espacio;
    public ListSalon(String nombre, String espacio) {
        this.nombre = nombre;
        this.espacio = espacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String nombre) {
        this.espacio = espacio;
    }

}
