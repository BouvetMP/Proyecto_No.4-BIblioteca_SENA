package com.sena;

public class Equipo {

    private String codigo;
    private String nombreEquipo;
    private String categoria;
    private boolean disponible;

    public Equipo(String codigo, String nombreEquipo, String categoria){

        setCodigo(codigo);
        setNombreEquipo(nombreEquipo);
        setCategoria(categoria);
        this.disponible = true;

    }

    public String getCodigo(){
        return codigo;
    }

    public String getNombreEquipo(){
        return nombreEquipo;
    }

    public String getCategoria(){
        return categoria;
    }

    public boolean getDisponible(){
        return disponible;
    }

    public void setCodigo(String codigo){
         if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("El Equipo debe de tener un codigo de identificación");
        }
        this.codigo = codigo;
    } 

    public void setNombreEquipo(String nombreEquipo){
         if(nombreEquipo == null || nombreEquipo.trim().isEmpty()){
            throw new IllegalArgumentException("El Equipo debe de tener un nombre de identificación");
        }
        this.nombreEquipo = nombreEquipo;
    }

    public void setCategoria(String categoria){
         if(categoria == null || categoria.trim().isEmpty()){
            throw new IllegalArgumentException("El Equipo debe de pertenecer a una clase");
        }
        this.categoria = categoria;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    public void marcarPrestado(){
        if(!disponible){
            throw new IllegalArgumentException("El equipo esta prestado");
        }
        this.disponible = false;
    }

    public void marcarDevuelto(){
        if(disponible){
            throw new IllegalArgumentException("El equipo ya esta disponible");

        }
        this.disponible = true;
    }
    
}
