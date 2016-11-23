package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 22/11/2016.
 */
public class SalaBD {
    private String estado, precio;

    public SalaBD(){
    }

    public SalaBD(String estado, String precio){

        this.estado=estado;
        this.precio=precio;
    }
    public String getEstado(){return estado;}
    public String getPrecio(){return precio;}

}
