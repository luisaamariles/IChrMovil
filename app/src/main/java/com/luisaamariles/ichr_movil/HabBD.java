package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 23/11/2016.
 */
public class HabBD {
    private String  precio,hab,estado;

    public HabBD(){
    }

    public HabBD( String hab,String precio, String estado){

        this.hab=hab;
        this.precio=precio;
        this.estado=estado;
    }

    public String getPrecio(){return precio;}

    public String getHab(){return hab;}

    public String getEstado(){return estado;}
}
