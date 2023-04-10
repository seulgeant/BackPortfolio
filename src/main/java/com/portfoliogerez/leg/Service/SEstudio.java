package com.portfoliogerez.leg.Service;

import com.portfoliogerez.leg.Entity.Estudio;
import com.portfoliogerez.leg.Repository.REstudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEstudio {

    @Autowired
    REstudio rEstudios;

    public List<Estudio> list() {
        return rEstudios.findAll();
    }

    public Optional<Estudio> getOne(int id) {
        return rEstudios.findById(id);
    }

    public Optional<Estudio> getbyInstitucion(String institucion) {
        return rEstudios.findByInstitucion(institucion);
    }

    public void save(Estudio estu) {
        rEstudios.save(estu);
    }

    public void delete(int id) {
        rEstudios.deleteById(id);
    }

    public boolean existsById(int id) {
        return rEstudios.existsById(id);
    }

    public boolean existsByInstitucion(String institucion) {
        return rEstudios.existsByInstitucion(institucion);
    }

}
