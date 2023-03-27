
package com.portafolio.RDSD.Service;

import com.portafolio.RDSD.Entity.Skills;
import com.portafolio.RDSD.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SSkills {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> List() {
        return rSkills.findAll();
    }
    public Optional<Skills> getOne(int id) {
        return rSkills.findById(id);
    }
    public Optional<Skills> getByNom(String nom) {
        return rSkills.findByNom(nom);
    }
    public void save(Skills skills){
        rSkills.save(skills);
    }
    public void delete(int id){
        rSkills.deleteById(id);
    }
    public boolean existsById(int id){
        return rSkills.existsById(id);
    }
    public boolean existsByNom(String nom){
        return rSkills.existsByNom(nom);
    }
}