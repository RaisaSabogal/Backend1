
package com.portafolio.RDSD.Controller;

import com.portafolio.RDSD.Dto.DEducation;
import com.portafolio.RDSD.Entity.Education;
import com.portafolio.RDSD.Security.Controller.Mensaje;
import com.portafolio.RDSD.Service.SEducation;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://portafolioraisa-2065e.web.app")
public class CEducation {
    
    @Autowired
    SEducation sEducation;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = sEducation.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if (!sEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Education educacion = sEducation.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!sEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sEducation.delete(id);
        return new ResponseEntity(new Mensaje("Education Eliminada"), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DEducation dtoedu) {

        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sEducation.existsByNombreE(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa Education existe"), HttpStatus.BAD_REQUEST);
        }

        Education educacion = new Education(dtoedu.getNombreE(), dtoedu.getDescripcionE());
        sEducation.save(educacion);
        return new ResponseEntity(new Mensaje("Education agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DEducation dtoedu) {
        //Validamos si existe el ID
        if (!sEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Education
        if (sEducation.existsByNombreE(dtoedu.getNombreE()) && sEducation.getByNombreE(dtoedu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Education ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Education educacion = sEducation.getOne(id).get();
        educacion.setNombreE(dtoedu.getNombreE());
        educacion.setDescripcionE(dtoedu.getDescripcionE());
        sEducation.save(educacion);
        return new ResponseEntity(new Mensaje("Education Actualizada"), HttpStatus.OK);
    }
}
