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
            System.out.println(" ENTRENADORES\n");
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
                    System.out.println("Ingrese el codigo del coach:\n");
                    String codigoCoach = scanner.nextLine();
                    System.out.println("Ingrese Nombre del coach:\n");
                    entrenadores.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la edad:\n");
                    entrenadores.setEdad(scanner.nextInt());
                    System.out.println("Ingrese el id de la federacion:\n");
                    entrenadores.setIdFederacion(scanner.nextInt());
                    if (controlador != null) {
                        controlador.entrenadores.put(codigoCoach, entrenadores);
                    } else {
                        System.out.println("Error: Controlador no inicializado.");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el codigo del coach a actualizar");
                    String codigoActualizar = scanner.nextLine();
                    Coach coachActualizar = controlador.entrenadores.get(codigoActualizar);
                    if (coachActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del coach (actual:" + coachActualizar.getNombre() + "):");
                        coachActualizar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la nueva edad del coach (actual: "+ coachActualizar.getEdad() + "):");
                        coachActualizar.setEdad(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Ingrese la nueva federacion del coach (actual: "+ coachActualizar.getIdFederacion() + "):");
                        coachActualizar.setIdFederacion(scanner.nextInt());
                        scanner.nextLine();
                        controlador.entrenadores.put(codigoActualizar, coachActualizar);
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
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
                System.out.println("Ingrese el codigo del coach a eliminar:");
                String codigoEliminar = scanner.nextLine();
                if (controlador.entrenadores.containsKey(codigoEliminar)) {
                    controlador.entrenadores.remove(codigoEliminar);
                    System.out.println("Coach eliminado exitosamente.");
                } else {
                    System.out.println("Coach no encontrado.");
                }
                    break;

                case 5:
                System.out.println("Lista de todos los coachs:");
                for (String key : controlador.entrenadores.keySet()) {
                    Coach coach = controlador.entrenadores.get(key);
                    System.out.println("Codigo: " + key + ", Nombre: " + coach.getNombre() + ", Edad: " + coach.getEdad() + ", Federacion: " + coach.getIdFederacion());
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
