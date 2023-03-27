
package com.portafolio.RDSD.Repository;

import com.portafolio.RDSD.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface REducation extends JpaRepository<Education,Integer> {
    
    public Optional<Education> findByNombreE(String nombreE);
    public Boolean existsByNombreE(String nombreE);
    
}

