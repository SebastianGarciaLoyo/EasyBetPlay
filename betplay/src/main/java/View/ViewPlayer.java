package View;

import java.util.Scanner;

import com.betplay.Controller;

import Model.Entity.Player;

public class ViewPlayer {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------");
            System.out.println("1. Añadir Jugador");
            System.out.println("2. Actualizar Jugador");
            System.out.println("3. Buscar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Listar todos Jugadores");
            System.out.println("6. Salir");
            System.out.println("------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading int

            switch (choice) {
                case 1:
                      // Agregar jugador
                    Player jugador = new Player();
                    System.out.println("Ingrese el codigo del jugador:");
                    String codigoJugador = scanner.nextLine();
                    System.out.println("Ingrese el nombre del jugador:");
                    jugador.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la edad del jugador");
                    jugador.setEdad(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Ingrese la dorsal del jugador");
                    jugador.setDorsal(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Ingrese la posicion del jugador");
                    jugador.setPosicion(scanner.nextLine());
                    if (controlador != null) {
                        controlador.jugadores.put(codigoJugador, jugador);
                    } else {
                        System.out.println("Error: Controlador no inicializado.");
                    }
                    break;

                case 2:
                    // Implementar actualización de equipo
                    break;

                case 3:
                    System.out.println("Ingrese el codigo del jugador a buscar:");
                    String codigoJ = scanner.nextLine();
                    Player jr = controlador.jugadores.get(codigoJ);
                    if (jr != null) {
                        System.out.println("Nombre del jugador: " + jr.getNombre());
                        System.out.println("Edad: " + jr.getEdad());
                        System.out.println("Ciudad: " + jr.getDorsal());
                        System.out.println("Posicion: " + jr.getPosicion());
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 4:
                    // Implementar eliminación de equipo
                    break;

                case 5:
                    // Implementar listado de todos los equipos
                    break;

                case 6:
                    System.out.println("Volviendo al menu principal.");
                    return;
                    

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}


