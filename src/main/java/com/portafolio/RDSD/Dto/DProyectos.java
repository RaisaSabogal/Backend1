
package com.portafolio.RDSD.Dto;

import javax.validation.constraints.NotBlank;


public class DProyectos {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descrip;
    //Cons

    public DProyectos() {
    }

    public DProyectos(String nombreP, String descrip) {
        this.nombreP = nombreP;
        this.descrip = descrip;
    }
    //GYS

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    
}
