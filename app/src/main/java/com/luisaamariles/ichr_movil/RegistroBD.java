package com.luisaamariles.ichr_movil;

/**
 * Created by Luisa Maria Amariles on 30/10/2016.
 */
public class RegistroBD {
    private String nombre, apellido, cedula,telefono, direccion, correo,profesion, motivo, id;

    public RegistroBD() {
    }
    public RegistroBD(String nombre, String apellido, String cedula, String telefono, String direccion, String correo, String profesion, String motivo, String id) {
        this.nombre = nombre;
        this.apellido= apellido;
        this.cedula = cedula;
        this.telefono= telefono;
        this.direccion= direccion;
        this.correo= correo;
        this.profesion=profesion;
        this.motivo= motivo;
        this.id = id;
    }

    public String getNombre() {return nombre;}

    public String getApellido() {return apellido;}

    public String getDireccion() {return direccion;}

    public String getCedula() { return cedula;}

    public String getTelefono() { return telefono;}

    public  String getCorreo() { return correo;}

    public String getProfesion() {return profesion;}

    public  String getMotivo() { return motivo;}

    public String getId() {
        return id;
    }
}
