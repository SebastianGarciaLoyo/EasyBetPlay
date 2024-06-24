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
                    System.out.println("Ingrese el codigo del equipo:");
                    String codigoEquipo = scanner.nextLine();
                    System.out.println("Ingrese Nombre del equipo:");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la ciudad:");
                    equipo.setCiudad(scanner.nextLine());
                    if (controlador != null) {
                        controlador.equipos.put(codigoEquipo, equipo);
                    } else {
                        System.out.println("Error: Controlador no inicializado.");
                    }
                    break;

                case 2:
                    // Implementar actualización de equipo
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
                    // Implementar eliminación de equipo
                    break;

                case 5:
                    // Implementar listado de todos los equipos
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

