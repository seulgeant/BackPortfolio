package com.portfoliogerez.leg.Service;

import com.portfoliogerez.leg.Entity.Persona;
import com.portfoliogerez.leg.Repository.Rpersona;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {

    @Autowired
    Rpersona rPersona;

    public Optional<Persona> getOne(int id) {
        return rPersona.findById(id);
    }


    public void save(Persona pers) {
        rPersona.save(pers);
    }

}
