package com.portfoliogerez.leg.Service;

import com.portfoliogerez.leg.Entity.Proyecto;
import com.portfoliogerez.leg.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {

    @Autowired
    RProyecto rProyecto;

    public List<Proyecto> list() {
        return rProyecto.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return rProyecto.findById(id);
    }

    public Optional<Proyecto> getbyNombreP(String nombreP) {
        return rProyecto.findByNombreP(nombreP);
    }

    public void save(Proyecto proy) {
        rProyecto.save(proy);
    }

    public void delete(int id) {
        rProyecto.deleteById(id);
    }

    public boolean existsById(int id) {
        return rProyecto.existsById(id);
    }

    public boolean existsByNombreP(String nombreP) {
        return rProyecto.existsByNombreP(nombreP);
    }
}
