
package com.portafolio.RDSD.Controller;

import com.portafolio.RDSD.Dto.DSkills;
import com.portafolio.RDSD.Entity.Skills;
import com.portafolio.RDSD.Security.Controller.Mensaje;
import com.portafolio.RDSD.Service.SSkills;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "https://portafolioraisa-2065e.web.app")
public class CSkills {
    
    @Autowired
    SSkills sSkills;
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = sSkills.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills educacion = sSkills.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skills Eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DSkills dtos) {

        if (StringUtils.isBlank(dtos.getNom())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sSkills.existsByNom(dtos.getNom())) {
            return new ResponseEntity(new Mensaje("Esa Skills existe"), HttpStatus.BAD_REQUEST);
        }

        Skills educacion = new Skills(dtos.getNom(), dtos.getPor());
        sSkills.save(educacion);
        return new ResponseEntity(new Mensaje("Skills agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DSkills dtos) {
        //Validamos si existe el ID
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Skills
        if (sSkills.existsByNom(dtos.getNom()) && sSkills.getByNom(dtos.getNom()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Skills ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtos.getNom())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills educacion = sSkills.getOne(id).get();
        educacion.setNom(dtos.getNom());
        educacion.setPor(dtos.getPor());
        sSkills.save(educacion);
        return new ResponseEntity(new Mensaje("Skills Actualizada"), HttpStatus.OK);
    }
}
