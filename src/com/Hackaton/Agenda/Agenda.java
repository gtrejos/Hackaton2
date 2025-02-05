package com.Hackaton.Agenda;
import com.Hackaton.Contacto.Contacto;
import java.util.ArrayList;

public class Agenda {
        private ArrayList<Contacto> contactos;
        private int capacidad;

        public Agenda() {
            this.capacidad = 10;
            this.contactos = new ArrayList<>();
        }

        public Agenda(int capacidad) {
            this.capacidad = capacidad;
            this.contactos = new ArrayList<>();
        }

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
        public boolean existeContacto(Contacto c) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(c.getNombre())) {
                return true;
            }
        }
         return false;
        }


    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            contactos.sort((c1, c2) -> {
                int comparacionNombre = c1.getNombre().compareToIgnoreCase(c2.getNombre());
                if (comparacionNombre == 0) {
                    return c1.getApellido().compareToIgnoreCase(c2.getApellido());
                }
                return comparacionNombre;
            });
            System.out.println("Contactos en la agenda:");
            for (Contacto c : contactos) {
                System.out.println(c);
              }
           }
        }
        public void buscaContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Número de télefono del usuario: " + c.getTelefono());
                return;
            }
        }
        System.out.println("No se encontró un contacto con el nombre y apellido: " + nombre + " " + apellido);
    }

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

        public boolean agendaLlena() {
            return contactos.size() >= capacidad;
        }

        public int espacioLibres() {
            return capacidad - contactos.size();
        }

    public void buscaContacto(String nombre) {

    }
}