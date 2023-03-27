
package com.portafolio.RDSD.Service;

import com.portafolio.RDSD.Entity.Education;
import com.portafolio.RDSD.Repository.REducation;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducation {
    @Autowired
    REducation rEducation;
    
    public List<Education> List() {
        return rEducation.findAll();
    }
    public Optional<Education> getOne(int id) {
        return rEducation.findById(id);
    }
    public Optional<Education> getByNombreE(String nombreE) {
        return rEducation.findByNombreE(nombreE);
    }
    public void save(Education edu){
        rEducation.save(edu);
    }
    public void delete(int id){
        rEducation.deleteById(id);
    }
    public boolean existsById(int id){
        return rEducation.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
        return rEducation.existsByNombreE(nombreE);
    }
}