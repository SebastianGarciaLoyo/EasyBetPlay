package View;

import java.util.Scanner;

import com.betplay.Controller;

import Model.Entity.Coach;

public class ViewCoach {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------");
            System.out.println("1. Añadir Coach");
            System.out.println("2. Actualizar Coach");
            System.out.println("3. Buscar Coach");
            System.out.println("4. Eliminar Coach");
            System.out.println("5. Listar todos los coachs");
            System.out.println("6. Volver");
            System.out.println("------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading int

            switch (choice) {
                case 1:
                    Coach entrenadores = new Coach();
                    System.out.println("Ingrese el codigo del coach:");
                    String codigoCoach = scanner.nextLine();
                    System.out.println("Ingrese Nombre del coach:");
                    entrenadores.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la edad:");
                    entrenadores.setEdad(scanner.nextInt());
                    System.out.println("Ingrese el id de la federacion:");
                    entrenadores.setIdFederacion(scanner.nextInt());
                    if (controlador != null) {
                        controlador.entrenadores.put(codigoCoach, entrenadores);
                    } else {
                        System.out.println("Error: Controlador no inicializado.");
                    }
                    break;

                case 2:
                    // Implementar actualización de equipo
                    break;

                case 3:
                    System.out.println("Ingrese el codigo del coach a buscar:");
                    String codigoC = scanner.nextLine();
                    Coach ch = controlador.entrenadores.get(codigoC);
                    if (ch != null) {
                        System.out.println("Nombre del coach: " + ch.getNombre());
                        System.out.println("Edad: " + ch.getEdad());
                        System.out.println("Federacion: " + ch.getIdFederacion());
                    } else {
                        System.out.println("Coach no encontrado.");
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
