package com.portafolio.RDSD.Repository;

import com.portafolio.RDSD.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository<Persona,Integer> {
    
    public Optional<Persona> findByNombre(String nombre);
    public Boolean existsByNombre(String nombre);
    
}
