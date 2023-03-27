
package com.portafolio.RDSD.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    
   @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int por;
    
    //constructor

    public Skills() {
    }

    public Skills(String nom, int por) {
        this.nom = nom;
        this.por = por;
    }

   //GYS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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