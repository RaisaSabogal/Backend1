/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.RDSD.Service;

import com.portafolio.RDSD.Entity.Persona;
import com.portafolio.RDSD.Repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SPersona {

    @Autowired
    RPersona ipR;

    public List<Persona> List() {
        return ipR.findAll();
    }
    public Optional<Persona> getOne(int id) {
        return ipR.findById(id);
    }
    public Optional<Persona> getByNombre(String nombre) {
        return ipR.findByNombre(nombre);
    }
    public void save(Persona per){
        ipR.save(per);
    }
    public void delete(int id){
        ipR.deleteById(id);
    }
    public boolean existsById(int id){
        return ipR.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return ipR.existsByNombre(nombre);
    }
}