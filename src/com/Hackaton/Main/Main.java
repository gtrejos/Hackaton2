package com.Hackaton.Main;

//*Se importaron las clases :
// Agenda:Para gestionar los contactos.
// Contácto: Representa un contacto.
// Scannr: Para la entrada del Usuario.
import com.Hackaton.Agenda.Agenda;
import com.Hackaton.Contacto.Contacto;
import java.util.Scanner;


public class Main {

        //* Se creo un objeto scanner para leer la entrada del usuario.
        //* Instacioa Agenda
        //* Variable para almacenar la opción seleccionada por el usuario

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Agenda agenda = new Agenda();
            int opcion;

            //*Muestra el menú de opciones al usuario

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

                //*Estructura de control para manejar las opciones del menú.

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Introduce el apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Introduce el teléfono: ");
                        String telefono = scanner.nextLine();
                        agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                        break;
                    case 2:
                        System.out.print("Introduce el nombre del contacto a verificar: ");
                        nombre = scanner.nextLine();
                        boolean existe = agenda.existeContacto(new Contacto(nombre, "", ""));
                        System.out.println(existe ? "El contacto existe." : "El contacto no existe.");
                        break;
                    case 3:
                        agenda.listarContactos();
                        break;
                    case 4:
                        System.out.print("Introduce el nombre del contacto a buscar: ");
                        nombre = scanner.nextLine();
                        agenda.buscaContacto(nombre);
                        break;
                    case 5:
                        System.out.print("Introduce el nombre del contacto a eliminar: ");
                        nombre = scanner.nextLine();
                        agenda.eliminarContacto(nombre);
                        break;
                    case 6:
                        System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "La agenda tiene espacio.");
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

