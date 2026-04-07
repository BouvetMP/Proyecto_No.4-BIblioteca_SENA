package com.sena;

public class Prestamo {

    private int id;
    private Aprendiz aprendiz;
    private Equipo equipo;
    private String fechaPrestamo;
    private boolean activo;

    public Prestamo(int id, Aprendiz aprendiz, Equipo equipo, String fechaPrestamo){
        setID(id);
        setAprendiz(aprendiz);
        setEquipo(equipo);
        setFechaPrestamo(fechaPrestamo);
        this.activo = true;
    }

    public int getID(){
        return id;
    }

    public Aprendiz getAprendiz(){
        return aprendiz;
    }

    public Equipo getEquipo(){
        return equipo;
    }

    public String getFechaPrestamo(){
        return fechaPrestamo;
    }

    public boolean getActivo(){
        return activo;
    }

    public void setID(int id){
        if(id <= 0){
            throw new IllegalArgumentException("El id del prestamo no puede ser 0");
        }
        this.id = id;
    }

    public void setAprendiz(Aprendiz aprendiz){
        if(aprendiz == null){
            throw new IllegalArgumentException("El prestamo debe de tener un aprendiz");
        }
        this.aprendiz = aprendiz;
    }

    public void setEquipo(Equipo equipo){
        if(equipo == null){
            throw new IllegalArgumentException("El prestamo debe de tener un equipo");
        }
        this.equipo = equipo;
    }

    public void setFechaPrestamo(String fechaPrestamo){
         if(fechaPrestamo == null || fechaPrestamo.trim().isEmpty()){
            throw new IllegalArgumentException("El prestamo debe de tener una fecha de prestamo");
        }
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    public void cerrarPrestamo(String fechaDevolución){
        if(!activo){
            throw new IllegalArgumentException("Este prestamo ya ha sido cerrado");
        }

        this.activo = false;

        this.equipo.marcarDevuelto();
        System.out.println("Prestamo cerrado, Fecha de devolución: " + fechaDevolución);
    }
}
