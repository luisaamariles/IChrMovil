package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 28/10/2016.
 */
public class UsuarioBD {
    private String nombre, apellido,  pais,  correo,usuario, contrasena;

    public UsuarioBD() {
    }
    public UsuarioBD(String nombre, String apellido,  String pais,  String correo, String usuario) {
        this.nombre = nombre;
        this.apellido= apellido;
        this.pais= pais;
        this.correo= correo;
        this.usuario=usuario;


    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPais() { return pais;}

    public  String getCorreo() { return correo;}

    public String getUsuario() {return usuario;}




}
