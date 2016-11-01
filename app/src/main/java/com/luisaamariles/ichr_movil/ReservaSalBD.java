package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 01/11/2016.
 */
public class ReservaSalBD {
    private String usuario, salon, fecha, hora, precio, id;

    public ReservaSalBD() {
    }
    public ReservaSalBD(String usuario, String salon, String fecha, String hora, String precio, String id) {
        this.usuario = usuario;
        this.salon = salon;
        this.fecha= fecha;
        this.hora= hora;
        this.precio= precio;
        this.id = id;
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

    public String getId() {
        return id;
    }
}
