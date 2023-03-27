
package com.portafolio.RDSD.Repository;


import com.portafolio.RDSD.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia,Integer> {
    
    public Optional<Experiencia> findByNombreX(String nombreX);
    public Boolean existsByNombreX(String nombreX);
}
