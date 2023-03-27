package com.portafolio.RDSD.Dto;

import javax.validation.constraints.NotBlank;

public class DSkills {

    @NotBlank
    private String nom;
    @NotBlank
    private int por;

    //constructor

    public DSkills() {
    }

    public DSkills(String nom, int por) {
        this.nom = nom;
        this.por = por;
    }
//GYS
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPor() {
        return por;
    }

    public void setPor(int por) {
        this.por = por;
    }
    

   
    
}