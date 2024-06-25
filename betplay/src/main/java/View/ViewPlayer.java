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
            System.out.println(" JUGADORES\n");
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
                    System.out.println("Ingrese el codigo del jugador:\n");
                    String codigoJugador = scanner.nextLine();
                    System.out.println("Ingrese el nombre del jugador:\n");
                    jugador.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la edad del jugador:\n");
                    jugador.setEdad(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Ingrese la dorsal del jugador:\n");
                    jugador.setDorsal(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Ingrese la posicion del jugador:\n");
                    jugador.setPosicion(scanner.nextLine());
                    if (controlador != null) {
                        controlador.jugadores.put(codigoJugador, jugador);
                    } else {
                        System.out.println("Error: Controlador no inicializado.");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el codigo del jugador a actualizar");
                    String codigoActualizar = scanner.nextLine();
                    Player jugadorActualizar = controlador.jugadores.get(codigoActualizar);
                    if (jugadorActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del jugador (actual:" + jugadorActualizar.getNombre() + "):");
                        jugadorActualizar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la nueva edad del jugador (actual: "+ jugadorActualizar.getEdad() + "):");
                        jugadorActualizar.setEdad(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Ingrese el nuevo dorsal del jugador (actual: "+ jugadorActualizar.getDorsal() + "):");
                        jugadorActualizar.setDorsal(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Ingrese la nueva posicion del jugador (actual: "+ jugadorActualizar.getPosicion() + "):");
                        jugadorActualizar.setPosicion(scanner.nextLine());
                        controlador.jugadores.put(codigoActualizar, jugadorActualizar);
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el codigo del jugador a buscar:");
                    String codigoJ = scanner.nextLine();
                    Player jr = controlador.jugadores.get(codigoJ);
                    if (jr != null) {
                        System.out.println("-------------------------------------");
                        System.out.println("Nombre del jugador: " + jr.getNombre());
                        System.out.println("Edad: " + jr.getEdad());
                        System.out.println("Dorsal: " + jr.getDorsal());
                        System.out.println("Posicion: " + jr.getPosicion());
                        System.out.println("-------------------------------------");
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 4:
                System.out.println("Ingrese el codigo del Jugador a eliminar:");
                String codigoEliminar = scanner.nextLine();
                if (controlador.jugadores.containsKey(codigoEliminar)) {
                    controlador.jugadores.remove(codigoEliminar);
                    System.out.println("Jugador eliminado exitosamente.");
                } else {
                    System.out.println("Jugador no encontrado.");
                }
                    break;

                case 5:
                    System.out.println("Lista de todos los Jugadores:");
                for (String key : controlador.jugadores.keySet()) {
                    Player player = controlador.jugadores.get(key);
                    System.out.println("Codigo: " + key + ", Nombre: " + player.getNombre() + ", Edad: " + player.getEdad() + ", Dorsal: " + player.getDorsal() + ", Posicion: " + player.getPosicion());
                }
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


