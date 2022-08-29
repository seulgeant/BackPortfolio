package com.portfoliogerez.leg.Service;

import com.portfoliogerez.leg.Entity.Soft;
import com.portfoliogerez.leg.Repository.RSoft;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSoft {

    @Autowired
    RSoft rSoft;

    public List<Soft> list() {
        return rSoft.findAll();
    }

    public Optional<Soft> getOne(int id) {
        return rSoft.findById(id);
    }

    public Optional<Soft> getbyTituloS(String tituloS) {
        return rSoft.findByTituloS(tituloS);
    }

    public void save(Soft soft) {
        rSoft.save(soft);
    }

    public void delete(int id) {
        rSoft.deleteById(id);
    }

    public boolean existsById(int id) {
        return rSoft.existsById(id);
    }

    public boolean existsByTituloS(String tituloS) {
        return rSoft.existsByTituloS(tituloS);
    }
}
