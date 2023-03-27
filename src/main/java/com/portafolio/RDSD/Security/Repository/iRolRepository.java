
package com.portafolio.RDSD.Security.Repository;

import com.portafolio.RDSD.Security.Entity.Rol;
import com.portafolio.RDSD.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
    
}
