
package com.portafolio.RDSD.Service;

import com.portafolio.RDSD.Entity.Proyectos;
import com.portafolio.RDSD.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class SProyectos {

    @Autowired
    RProyectos ipR;

    public List<Proyectos> List() {
        return ipR.findAll();
    }
    public Optional<Proyectos> getOne(int id) {
        return ipR.findById(id);
    }
    public Optional<Proyectos> getByNombreP(String nombreP) {
        return ipR.findByNombreP(nombreP);
    }
    public void save(Proyectos pro){
        ipR.save(pro);
    }
    public void delete(int id){
        ipR.deleteById(id);
    }
    public boolean existsById(int id){
        return ipR.existsById(id);
    }
    public boolean existsByNombreP(String nombreP){
        return ipR.existsByNombreP(nombreP);
    }
}  
