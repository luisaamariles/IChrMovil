package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 31/10/2016.
 */
public class ReservaHabBD {
    private String usuario, numhab, fechain, fechasal, precio;

    public ReservaHabBD() {
    }
    public ReservaHabBD(String usuario, String numhab, String fechain, String fechasal, String precio) {
        this.usuario = usuario;
        this.numhab = numhab;
        this.fechain= fechain;
        this.fechasal= fechasal;
        this.precio= precio;

    }

    public String getUsuario() {
        return usuario;
    }

    public String getNumhab() {
        return numhab;
    }

    public String getFechain() { return fechain;}

    public String getFechasal() { return fechasal;}

    public  String getPrecio() { return precio;}


}
