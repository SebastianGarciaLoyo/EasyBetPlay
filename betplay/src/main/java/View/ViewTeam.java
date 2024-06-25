package View;

import java.util.Scanner;
import com.betplay.Controller;


import Model.Entity.Team;

public class ViewTeam {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------");
            System.out.println(" EQUIPOS\n");
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Volver");
            System.out.println("------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading int

            switch (choice) {
                case 1:
                    Team equipo = new Team();
                    System.out.println("Ingrese el codigo del equipo:\n");
                    String codigoEquipo = scanner.nextLine();
                    System.out.println("Ingrese Nombre del equipo:\n");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la ciudad:\n");
                    equipo.setCiudad(scanner.nextLine());
                    if (controlador != null) {
                        controlador.equipos.put(codigoEquipo, equipo);
                    } else {
                        System.out.println("Error: Controlador no inicializado.");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el codigo del equipo a actualizar:");
                    String codigoActualizar = scanner.nextLine();
                    Team equipoActualizar = controlador.equipos.get(codigoActualizar);
                    if (equipoActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del equipo (actual: " + equipoActualizar.getNombre() + "):");
                        equipoActualizar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la nueva ciudad del equipo (actual: " + equipoActualizar.getCiudad() + "):");
                        equipoActualizar.setCiudad(scanner.nextLine());
                        controlador.equipos.put(codigoActualizar, equipoActualizar);
                        System.out.println("Equipo actualizado exitosamente.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el codigo del equipo a buscar:");
                    String codigoE = scanner.nextLine();
                    Team eq = controlador.equipos.get(codigoE);
                    if (eq != null) {
                        System.out.println("Nombre del equipo: " + eq.getNombre());
                        System.out.println("Ciudad: " + eq.getCiudad());
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 4:
                System.out.println("Ingrese el codigo del equipo a eliminar:");
                String codigoEliminar = scanner.nextLine();
                if (controlador.equipos.containsKey(codigoEliminar)) {
                    controlador.equipos.remove(codigoEliminar);
                    System.out.println("Equipo eliminado exitosamente.");
                } else {
                    System.out.println("Equipo no encontrado.");
                }
                    break;

                case 5:
                    System.out.println("Lista de todos los equipos:");
                for (String key : controlador.equipos.keySet()) {
                    Team team = controlador.equipos.get(key);
                    System.out.println("Codigo: " + key + ", Nombre: " + team.getNombre() + ", Ciudad: " + team.getCiudad());
                }
                    break;

                case 6:
                    System.out.println("Volviendo al menú principal.");
                    return;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
