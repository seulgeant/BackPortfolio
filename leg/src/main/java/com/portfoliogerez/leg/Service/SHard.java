package com.portfoliogerez.leg.Service;

import com.portfoliogerez.leg.Entity.Hard;
import com.portfoliogerez.leg.Repository.RHard;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHard {

    @Autowired
    RHard rHard;

    public List<Hard> list() {
        return rHard.findAll();
    }

    public Optional<Hard> getOne(int id) {
        return rHard.findById(id);
    }

    public Optional<Hard> getbyTituloH(String tituloH) {
        return rHard.findByTituloH(tituloH);
    }

    public void save(Hard hard) {
        rHard.save(hard);
    }

    public void delete(int id) {
        rHard.deleteById(id);
    }

    public boolean existsById(int id) {
        return rHard.existsById(id);
    }

    public boolean existsByTituloH(String tituloH) {
        return rHard.existsByTituloH(tituloH);
    }
}
