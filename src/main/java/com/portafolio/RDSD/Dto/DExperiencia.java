package com.portafolio.RDSD.Dto;

import javax.validation.constraints.NotBlank;

public class DExperiencia {

    @NotBlank
    private String nombreX;
    @NotBlank
    private String descripcionX;

    //Constructor
    public DExperiencia() {
    }

    public DExperiencia(String nombreX, String descripcionX) {
        this.nombreX = nombreX;
        this.descripcionX = descripcionX;
    }
    //G Y S

    public String getNombreX() {
        return nombreX;
    }

    public void setNombreX(String nombreX) {
        this.nombreX = nombreX;
    }

    public String getDescripcionX() {
        return descripcionX;
    }

    public void setDescripcionX(String descripcionX) {
        this.descripcionX = descripcionX;
    }

}
