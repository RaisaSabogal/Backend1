package com.portafolio.RDSD.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descrip;
    
    //constructor

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String descrip) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descrip = descrip;
    }
    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

}
