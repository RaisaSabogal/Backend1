
package com.portafolio.RDSD.Repository;

import com.portafolio.RDSD.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository<Skills,Integer> {
    
    public Optional<Skills> findByNom(String nom);
    public Boolean existsByNom(String nom);
}
