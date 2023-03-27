package com.portafolio.RDSD.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Experiencia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreX;
    private String descripcionX;
    
    //CONS

    public Experiencia() {
    }

    public Experiencia(String nombreX, String descripcionX) {
        this.nombreX = nombreX;
        this.descripcionX = descripcionX;
    }
    
    //GYS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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