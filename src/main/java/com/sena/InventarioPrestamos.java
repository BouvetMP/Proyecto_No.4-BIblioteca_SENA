package com.sena;

import java.util.ArrayList;
import java.util.Scanner;

public class InventarioPrestamos {
    
    private ArrayList<Aprendiz> estudiantes = new ArrayList<>();
    private ArrayList<Equipo> computadoras = new ArrayList<>();
    private ArrayList<Prestamo> prestados = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void agregarAprendiz(){
        System.out.println("\nAgregando Aprendiz al sistema");
        System.out.println("Documento: ");
        String documento = scanner.nextLine();
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ficha: ");
        String ficha = scanner.nextLine();
        System.out.println("Telefono: ");
        String telefono = scanner.nextLine();
        estudiantes.add(new Aprendiz(documento, nombre, ficha, telefono));
        System.out.println("Se ha añadido un nuevo estudiante");
    }

    public void agregarEquipo(){
        System.out.println("\nAgregando equipo al sistema: ");
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Nombre del Equipo: ");
        String nombreEquipo = scanner.nextLine();
        System.out.println("Categoria: (Computo, Herramienta, Electronica)");
        String categoria = scanner.nextLine();
        computadoras.add(new Equipo(codigo, nombreEquipo, categoria));
        System.out.println("Ha sido agregado un nuevo Equipo");
    }

    public void listarEquipos(){
        for(Equipo equipo: computadoras){
            System.out.println("Codigo: " + equipo.getCodigo() + " - Nombre: " + equipo.getNombreEquipo()
         + " - Disponible: " + equipo.getDisponible());
        }
    }

    public void buscarEquipos(){
    System.out.print("Ingrese el código del equipo: ");
    String codigo = scanner.nextLine();

    Equipo equipo = null;
    for(Equipo e: computadoras){
        if(e.getCodigo().equals(codigo)){
            equipo = e;
        }
    }

    if(equipo == null){
        System.out.println("No se encontró ningún equipo con ese código");
        return;
    }

    System.out.println("\n--- Equipo Encontrado ---");
    System.out.println("Código: " + equipo.getCodigo());
    System.out.println("Nombre: " + equipo.getNombreEquipo());
    System.out.println("Categoría: " + equipo.getCategoria());
    System.out.println("Disponible: " + equipo.getDisponible());
}

    public void prestarEquipo(){
        System.out.println("Documento del Aprendiz: ");
        String documento = scanner.nextLine();
        System.out.println("Código del Equipo: ");
        String codigo = scanner.nextLine();
        System.out.println("Fecha de Prestamo: ");
        String fechaPrestamo = scanner.nextLine();

        Aprendiz aprendiz = null;
        for(Aprendiz a: estudiantes){
            if(a.getDocumento().equals(documento)){
                aprendiz = a;
            }
        }

        Equipo equipo = null;
        for(Equipo e: computadoras){
            if(e.getCodigo().equals(codigo)){
                equipo = e;
            }
        }

        if(aprendiz == null){
            throw new IllegalArgumentException("El Aprendiz no existe");
        }

        if(equipo == null){
            throw new IllegalArgumentException("El Equipo no existe");
        }

        if(!equipo.getDisponible()){
            throw new IllegalArgumentException("Este Equipo no esta disponible");
        }

        equipo.marcarPrestado();
        prestados.add(new Prestamo(prestados.size() + 1, aprendiz, equipo, fechaPrestamo));
        System.out.println("Prestamo registrado con exito");
    }

    public void listarActivos(){
        for(Prestamo prestamo: prestados){
            if(prestamo.getActivo()){
                System.out.println("Id: " + prestamo.getID() + " - Aprendiz: " + prestamo.getAprendiz().getNombre()
            + " - Equipo: " + prestamo.getEquipo().getNombreEquipo());
            }
        }
    }

    public void devolverEquipo(){
        System.out.println("ID del prestamo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Fecha de devolucion");
        String fecha = scanner.nextLine();

        for(Prestamo prestamo: prestados){
            if(prestamo.getID() == id){
                prestamo.cerrarPrestamo(fecha);
                return;
            }
        }
        throw new IllegalArgumentException("Prestamo no encontrado");
    }
}
