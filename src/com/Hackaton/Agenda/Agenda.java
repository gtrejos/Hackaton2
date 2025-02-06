package com.Hackaton.Agenda;
import com.Hackaton.Contacto.Contacto;
import java.util.ArrayList;

//*Clase Agenda que gestiona una lista de contactos.
 //* Permite añadir, buscar, listar y eliminar contactos.

public class Agenda {
    // Lista que almacena los contactos
    private ArrayList<Contacto> contactos;
    // Capacidad máxima de la agenda
    private int capacidad;


    //* Constructor que permite establecer una capacidad específica para la agenda.
    public Agenda(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new ArrayList<>();
    }

    //*Añade un contacto a la agenda si hay espacio y no existe ya.
    public void añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena. No se puede añadir más contactos.");
        } else if (existeContacto(c)) {
            System.out.println("El contacto ya existe en la agenda.");
        } else {
            contactos.add(c);
            System.out.println("Contacto añadido: " + c);
        }
    }

    //*Verifica si un contacto ya existe en la agenda.
    //*  c El contacto a verificar.
    //* return true si el contacto existe, false en caso contrario.
    public boolean existeContacto(Contacto c) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(c.getNombre())) {
                return true;
            }
        }
        return false;
    }

    //* Lista todos los contactos en la agenda, ordenados por nombre y apellido.
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.No hay contactos");
            return;
        }

            System.out.println("Lista de Contactos:");
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        }

    //*Busca un contacto por nombre y apellido y muestra su número de teléfono.
    //*nombre : El nombre del contacto a buscar.
    //*apellido: El apellido del contacto a buscar.

    public void buscaContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Número de teléfono del usuario: " + c.getTelefono());
                return;
            }
        }
        System.out.println("No se encontró un contacto con el nombre y apellido: " + nombre + " " + apellido);
    }

    //* Elimina un contacto de la agenda por su nombre.
    //*  nombre : El nombre del contacto a eliminar.

    public void eliminarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(c);
                System.out.println("Contacto eliminado: " + c);
                return;
            }
        }
        System.out.println("El contacto no existe en la agenda.");
    }

    //*Verifica si la agenda está llena.
    //* return: true si la agenda está llena, false en caso contrario.

    public boolean agendaLlena() {
        return contactos.size() >= capacidad;
    }

    //* Calcula el número de espacios libres en la agenda.
    //*return:El número de espacios libres.
    public int espacioLibres() {
        return capacidad - contactos.size();
    }

}

