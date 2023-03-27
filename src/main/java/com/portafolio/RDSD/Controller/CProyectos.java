/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.RDSD.Controller;

import com.portafolio.RDSD.Dto.DProyectos;
import com.portafolio.RDSD.Entity.Proyectos;
import com.portafolio.RDSD.Security.Controller.Mensaje;
import com.portafolio.RDSD.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://portafolioraisa-2065e.web.app")
public class CProyectos {
    
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyectos educacion = sProyectos.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyectos Eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DProyectos dtoedu) {

        if (StringUtils.isBlank(dtoedu.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sProyectos.existsByNombreP(dtoedu.getNombreP())) {
            return new ResponseEntity(new Mensaje("Esa Proyectos existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos educacion = new Proyectos(dtoedu.getNombreP(), dtoedu.getDescrip());
        sProyectos.save(educacion);
        return new ResponseEntity(new Mensaje("Proyectos agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DProyectos dtoedu) {
        //Validamos si existe el ID
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Proyectos
        if (sProyectos.existsByNombreP(dtoedu.getNombreP()) && sProyectos.getByNombreP(dtoedu.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Proyectos ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoedu.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proy = sProyectos.getOne(id).get();
        proy.setNombreP(dtoedu.getNombreP());
        proy.setDescrip(dtoedu.getDescrip());
        sProyectos.save(proy);
        return new ResponseEntity(new Mensaje("Proyectos Actualizada"), HttpStatus.OK);
    }
}