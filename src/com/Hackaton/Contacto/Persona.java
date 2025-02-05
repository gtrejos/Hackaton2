package com.Hackaton.Contacto;

public class Persona {
    private String nombre;
    private String apellido;

    // Constructor que inicializa la persona con nombre y apellido
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //* Métod getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }
    // Métod gtter para obtener el apellido
    public String getApellido() {
        return apellido;
    }

    // Métdo toString para mostrar la representación de la persona
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido;
    }
}