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
            System.out.println(" DOCTORES\n");
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
                System.out.println("Ingrese el id del doctor:\n");
                String codigoDoctor = scanner.nextLine();
                System.out.println("Ingrese Nombre del doctor:\n");
                doctor.setNombre(scanner.nextLine());
                System.out.println("Ingrese la edad del doctor:\n");
                doctor.setEdad(scanner.nextInt());
                scanner.nextLine(); // Consumir nueva línea después de nextInt()
                System.out.println("Ingrese el titulo:\n");
                doctor.setTitulo(scanner.nextLine());
                System.out.println("Ingrese los años de experiencia:\n");
                doctor.setExpYear(scanner.nextInt());
                scanner.nextLine(); // Consumir nueva línea después de nextInt()
            
                if (controlador != null) {
                    controlador.doctores.put(codigoDoctor, doctor);
                } else {
                    System.out.println("Error: Controlador no inicializado.");
                }
                break;
            

                case 2:
                    System.out.println("Ingrese el codigo del doctor a actualizar");
                    String codigoActualizar = scanner.nextLine();
                    Doctor doctorActualizar = controlador.doctores.get(codigoActualizar);
                    if (doctorActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del doctor (actual:" + doctorActualizar.getNombre() + "):");
                        doctorActualizar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la nueva edad del doctor (actual: "+ doctorActualizar.getEdad() + "):");
                        doctorActualizar.setEdad(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Ingrese el nuevo titulo del doctor (actual: "+ doctorActualizar.getTitulo() + "):");
                        doctorActualizar.setTitulo(scanner.nextLine());
                        scanner.nextLine();
                        System.out.println("Ingrese los nuevos años de experiencia del doctor (actual: "+ doctorActualizar.getExpYear() + "):");
                        doctorActualizar.setExpYear(scanner.nextInt());
                        controlador.doctores.put(codigoActualizar, doctorActualizar);
                    } else {
                        System.out.println("Doctor no encontrado.");
                    }
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
                System.out.println("Ingrese el codigo del doctor a eliminar:");
                String codigoEliminar = scanner.nextLine();
                if (controlador.doctores.containsKey(codigoEliminar)) {
                    controlador.doctores.remove(codigoEliminar);
                    System.out.println("Doctor eliminado exitosamente.");
                } else {
                    System.out.println("Doctor no encontrado.");
                }
                    break;

                case 5:
                    System.out.println("Lista de todos los doctores:");
                for (String key : controlador.doctores.keySet()) {
                    Doctor Doctor = controlador.doctores.get(key);
                    System.out.println("Codigo: " + key + ", Nombre: " + Doctor.getNombre() + ", Edad: " + Doctor.getEdad() + ", Titulo: " + Doctor.getTitulo() + ", Experiencia: " + Doctor.getExpYear());
                }
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
