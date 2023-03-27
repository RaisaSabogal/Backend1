
package com.portafolio.RDSD.Service;

import com.portafolio.RDSD.Entity.Experiencia;
import com.portafolio.RDSD.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> List() {
        return rExperiencia.findAll();
    }
    public Optional<Experiencia> getOne(int id) {
        return rExperiencia.findById(id);
    }
    public Optional<Experiencia> getByNombreX(String nombreX) {
        return rExperiencia.findByNombreX(nombreX);
    }
    public void save(Experiencia exp){
        rExperiencia.save(exp);
    }
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    public boolean existsByNombreX(String nombreX){
        return rExperiencia.existsByNombreX(nombreX);
    }
}
