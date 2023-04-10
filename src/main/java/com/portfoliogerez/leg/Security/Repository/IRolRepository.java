package com.portfoliogerez.leg.Security.Repository;

import com.portfoliogerez.leg.Security.Entity.Rol;
import com.portfoliogerez.leg.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
