package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 28/10/2016.
 */
public class Usuario {
    private String nombre, apellido, direccion, pais, ciudad, correo, contrasena, id;

    public Usuario() {
    }
    public Usuario(String nombre, String apellido, String direccion, String pais, String ciudad,String correo, String contrasena, String id) {
        this.nombre = nombre;
        this.apellido= apellido;
        this.direccion = direccion;
        this.pais= pais;
        this.ciudad= ciudad;
        this.correo= correo;
        this.contrasena= contrasena;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPais() { return pais;}

    public String getCiudad() { return ciudad;}

    public  String getCorreo() { return correo;}

    public  String getContrasena() { return contrasena;}

    public String getId() {
        return id;
    }
}
