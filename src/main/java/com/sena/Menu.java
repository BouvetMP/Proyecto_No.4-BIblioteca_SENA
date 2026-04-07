package com.sena;

import java.util.Scanner;

public class Menu {

    private InventarioPrestamos inventarioPrestamos = new InventarioPrestamos();
    private Scanner scanner = new Scanner(System.in);
    
    public void mostrarMenu(){
        int opcion = 0;
        while(opcion != 7){
            System.out.println("\n----Sistema de Prestamos de Equipos SENA----");
            System.out.println("1. Registrar Aprendiz");
            System.out.println("2. Registrar Equipos");
            System.out.println("3. Listar Equipos");
            System.out.println("4. Prestar Equipos");
            System.out.println("5. Listar Prestamos Activos");
            System.out.println("6. Devolver Equipos");
            System.out.println("7. Buscar Equipo por Código");
            System.out.println("8. Salir");
            System.out.println("Elija una Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1: inventarioPrestamos.agregarAprendiz();; break;
                case 2: inventarioPrestamos.agregarEquipo();; break;
                case 3: inventarioPrestamos.listarEquipos(); break;
                case 4: inventarioPrestamos.prestarEquipo(); break;
                case 5: inventarioPrestamos.listarActivos(); break;
                case 6: inventarioPrestamos.devolverEquipo(); break;
                case 7: inventarioPrestamos.buscarEquipos(); break;
                case 8: System.out.println("Ha salido del sistema de prestamo."); break;
                default: System.out.println("Opción no valida");
            }
        }
    }
}
