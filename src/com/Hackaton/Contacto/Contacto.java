package com.Hackaton.Contacto;


public class Contacto extends Persona {
    private String telefono;


    //* Constructor que inicializa el contacto con nombre, apellido y teléfono
    public Contacto(String nombre, String apellido, String telefono) {
        super(nombre, apellido);
        this.telefono = telefono;
    }

    //* Métoodo getter para obtener el teléfono del contacto
    public String getTelefono() {

        return telefono;
    }

    //* Métoodo toString para mostrar la representación del contacto
    @Override
    public String toString() {

        return super.toString() + ", Teléfono: " + telefono;
    }
}
