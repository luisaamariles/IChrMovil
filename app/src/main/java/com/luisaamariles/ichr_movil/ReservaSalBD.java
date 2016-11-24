package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 01/11/2016.
 */
public class ReservaSalBD {
    private String usuario, salon, fecha, hora, precio, acomodacion;

    public ReservaSalBD() {
    }
    public ReservaSalBD(String usuario, String salon, String fecha, String hora, String precio, String acomodacion) {
        this.usuario = usuario;
        this.salon = salon;
        this.fecha= fecha;
        this.hora= hora;
        this.precio= precio;
        this.acomodacion=acomodacion;

    }

    public String getUsuario() {
        return usuario;
    }

    public String getSalon() {
        return salon;
    }

    public String getFecha() { return fecha;}

    public String getHora() { return hora;}

    public  String getPrecio() { return precio;}

    public String getAcomodacion() {return acomodacion;}

}
