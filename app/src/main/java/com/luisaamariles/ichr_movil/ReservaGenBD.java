package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 01/11/2016.
 */
public class ReservaGenBD {
    private String usuario, tipo, hora;

    public ReservaGenBD() {
    }
    public ReservaGenBD(String usuario, String tipo, String hora) {
        this.usuario = usuario;
        this.tipo= tipo;
        this.hora= hora;


    }

    public String getUsuario() {
        return usuario;
    }


    public String getTipo() { return tipo;}

    public String getHora() { return hora;}



}
