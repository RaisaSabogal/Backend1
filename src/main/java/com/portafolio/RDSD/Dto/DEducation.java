
package com.portafolio.RDSD.Dto;

import javax.validation.constraints.NotBlank;

public class DEducation {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    //constructor
    public DEducation() {
    }

    public DEducation(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    //G Y S

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
 }