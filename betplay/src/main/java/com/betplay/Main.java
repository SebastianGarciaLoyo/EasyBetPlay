package com.betplay;

import java.util.Scanner;

import View.ViewCoach;
import View.ViewDoctor;
import View.ViewPlayer;
import View.ViewTeam;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("------------------------");
            System.out.println("MENUS\n");
            System.out.println("1. Menu Equipos");
            System.out.println("2. Menu Jugadores");
            System.out.println("3. Menu Coachs");
            System.out.println("4. Menu Doctores");
            System.out.println("5. Salir");
            System.out.println("--------------------------");

            System.out.println("\nDigite el menu a escoger");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un numero valido.");
                scanner.next(); 
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading int

            switch (opcion) {
                case 1:
                    Controller ctrlTeams = new Controller();
                    ViewTeam.controlador = ctrlTeams;
                    ViewTeam vt = new ViewTeam();
                    vt.start();
                    break;
                case 2:
                    Controller ctrlPlayer = new Controller();
                    ViewPlayer.controlador = ctrlPlayer;
                    ViewPlayer vp = new ViewPlayer();
                    vp.start();
                    break;
                case 3:
                    Controller ctrlCoach = new Controller();
                    ViewCoach.controlador = ctrlCoach;
                    ViewCoach vc = new ViewCoach();
                    vc.start();
                    break;
                case 4:
                    Controller ctrlDoctor = new Controller();
                    ViewDoctor.controlador = ctrlDoctor;
                    ViewDoctor vd = new ViewDoctor();
                    vd.start();
                    break;
                case 5:
                    System.out.println("\nPrograma finalizado");
                    break;
                default:
                    System.out.println("Opcion no valida o fuera de rango");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
