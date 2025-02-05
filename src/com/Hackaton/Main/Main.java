package com.Hackaton.Main;

import com.Hackaton.Agenda.Agenda;
import com.Hackaton.Contacto.Contacto;
import java.util.Scanner;

//*Clase principal que gestiona la interacción del usuario con la agenda de contactos.
public class Main {

//*Métoodo principal que inicia la aplicación y presenta un menú para gestionar contactos.

        public static void main(String[] args) {

//* Crear un objeto Scanner para leer la entrada del usuario desde la consola.

            Scanner scanner = new Scanner(System.in);
            int opcion;
            String nombre;
            String apellido;
            String telefono;

//* Solicitar al usuario la capacidad de la agenda o usar el valor por defecto.

            System.out.println("Digite el cantidad de contactos que quieres agregar en la agenda o digite 0 para dejarla por defecto:");
            int capacidad = scanner.nextInt();
            if (capacidad == 0) {
                capacidad = 10;

            }
            Agenda agenda = new Agenda(capacidad);

//* Mostrar el menú de opciones disponibles para gestionar la agenda de contactos.

            do {
                System.out.println("--- Menú de la Agenda ---");
                System.out.println("1. Añadir contacto");
                System.out.println("2. Verificar si un contacto existe");
                System.out.println("3. Listar todos los contactos");
                System.out.println("4. Buscar un contacto por nombre");
                System.out.println("5. Eliminar un contacto");
                System.out.println("6. Verificar si la agenda está llena");
                System.out.println("7. Ver espacios libres en la agenda");
                System.out.println("8. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

//* Estructura de control switch para manejar las opciones seleccionadas por el usuario en el menú.

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce el nombre: ");
                        nombre = scanner.nextLine();
                        System.out.print("Introduce el apellido: ");
                        apellido = scanner.nextLine();
                        System.out.print("Introduce el teléfono: ");
                        telefono = scanner.nextLine();
                        agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                        break;
                    case 2:
                        System.out.print("Introduce el nombre del contacto a verificar: ");
                        nombre = scanner.nextLine();
                        System.out.print("Introduce el apellido del contacto a verificar: ");
                        apellido = scanner.nextLine();
                        boolean existe = agenda.existeContacto(new Contacto(nombre, apellido,""));
                        System.out.println(existe);
                        if (existe) {
                            System.out.println("El contacto existe.");
                        } else {
                            System.out.println("El contacto no existe.");
                        }
                        break;
                    case 3:
                        agenda.listarContactos();
                        break;
                    case 4:
                        System.out.print("Introduce el nombre del contacto a buscar: ");
                        nombre = scanner.nextLine();
                        System.out.print("Introduce el apellido del contacto a buscar: ");
                        apellido = scanner.nextLine();
                        agenda.buscaContacto(nombre, apellido);
                        break;
                    case 5:
                        System.out.print("Introduce el nombre del contacto a eliminar: ");
                        nombre = scanner.nextLine();
                        agenda.eliminarContacto(nombre);
                        break;
                    case 6:
                        if (agenda.agendaLlena()) {
                            System.out.println("La agenda está llena.");
                        } else {
                            System.out.println("La agenda tiene espacio.");
                        }
                        break;
                    case 7:
                        System.out.println("Espacios libres: " + agenda.espacioLibres());
                        break;
                    case 8:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 8);

            scanner.close();
        }
}

