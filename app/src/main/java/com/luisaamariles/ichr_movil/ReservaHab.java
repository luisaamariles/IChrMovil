package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 30/10/2016.
 */
public class ReservaHab {
    private String nombre, estado, numhab, fechain, fechasal, precio, id;

    public ReservaHab() {
    }
    public ReservaHab(String nombre, String estado, String numhab, String fechain, String fechasal,String precio, String id) {
        this.nombre = nombre;
        this.estado= estado;
        this.numhab = numhab;
        this.fechain= fechain;
        this.fechasal= fechasal;
        this.precio= precio;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getNumhab() {
        return numhab;
    }

    public String getFechain() { return fechain;}

    public String getFechasal() { return fechasal;}

    public  String getPrecio() { return precio;}

    public String getId() {
        return id;
    }
}
