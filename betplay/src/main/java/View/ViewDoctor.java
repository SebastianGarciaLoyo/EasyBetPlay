package View;

import java.util.Scanner;

import com.betplay.Controller;

import Model.Entity.Doctor;



public class ViewDoctor {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------");
            System.out.println("1. Añadir Doctor");
            System.out.println("2. Actualizar Doctor");
            System.out.println("3. Buscar Doctor");
            System.out.println("4. Eliminar Doctor");
            System.out.println("5. Listar todos los doctores");
            System.out.println("6. Volver");
            System.out.println("------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading int

            switch (choice) {
                case 1:
                Doctor doctor = new Doctor();
                System.out.println("Ingrese el id del doctor:");
                String codigoDoctor = scanner.nextLine();
                System.out.println("Ingrese Nombre del doctor:");
                doctor.setNombre(scanner.nextLine());
                System.out.println("Ingrese la edad del doctor:");
                doctor.setEdad(scanner.nextInt());
                scanner.nextLine(); // Consumir nueva línea después de nextInt()
                System.out.println("Ingrese el titulo:");
                doctor.setTitulo(scanner.nextLine());
                System.out.println("Ingrese los años de experiencia:");
                doctor.setExpYear(scanner.nextInt());
                scanner.nextLine(); // Consumir nueva línea después de nextInt()
            
                if (controlador != null) {
                    controlador.doctores.put(codigoDoctor, doctor);
                } else {
                    System.out.println("Error: Controlador no inicializado.");
                }
                break;
            

                case 2:
                    // Implementar actualización de equipo
                    break;

                case 3:
                    System.out.println("Ingrese el codigo del equipo a buscar:");
                    String codigoD = scanner.nextLine();
                    Doctor dt = controlador.doctores.get(codigoD);
                    if (dt != null) {
                        System.out.println("Nombre del equipo: " + dt.getNombre());
                        System.out.println("Edad: " + dt.getEdad());
                        System.out.println("Titulo: " + dt.getTitulo());
                        System.out.println("Experiencia: " + dt.getExpYear());
                    } else {
                        System.out.println("Doctor no encontrado.");
                    }
                    break;

                case 4:
                    // Implementar eliminación de equipo
                    break;

                case 5:
                    // Implementar listado de todos los equipos
                    break;

                case 6:
                    System.out.println("Volviendo al menu principal");
                    return;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
