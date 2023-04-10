package com.portfoliogerez.leg.Security.Service;

import com.portfoliogerez.leg.Security.Entity.Rol;
import com.portfoliogerez.leg.Security.Enums.RolNombre;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfoliogerez.leg.Security.Repository.IRolRepository;

@Service
@Transactional

public class SRol {

    @Autowired
    IRolRepository iRolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return iRolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        iRolRepository.save(rol);
    }
}
