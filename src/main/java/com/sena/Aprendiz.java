package com.sena;

public class Aprendiz {

    private String documento;
    private String nombre;
    private String ficha;
    private String telefono;

    public Aprendiz(String documento, String nombre, String ficha, String telefono){

        setDocumento(documento);
        setNombre(nombre);
        setFicha(ficha);
        setTelefono(telefono);
    }

    public String getDocumento(){
        return documento;
    }

    public String getNombre(){
        return nombre;
    }

    public String getFicha(){
        return ficha;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setDocumento(String documento){
         if(documento == null || documento.trim().isEmpty()){
            throw new IllegalArgumentException("El aprendiz debe de tener un documento");
        }
        this.documento = documento;
    }

    public void setNombre(String nombre){
         if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El aprendiz debe de llevar nombre");
        }
        this.nombre = nombre;
    }

    public void setFicha(String ficha){
         if(ficha == null || ficha.trim().isEmpty()){
            throw new IllegalArgumentException("El aprendiz debe de pertenecer a una ficha");
        }
        this.ficha = ficha;
    }

    public void setTelefono(String telefono){
         if(telefono == null || telefono.trim().isEmpty()){
            throw new IllegalArgumentException("El aprendiz debe de tener un número de contacto");
        }

        if(telefono.length() < 10){
            throw new IllegalArgumentException("El número de contacto debe de tener mas de 10 digitos");
        }
        this.telefono = telefono;
    }
}
