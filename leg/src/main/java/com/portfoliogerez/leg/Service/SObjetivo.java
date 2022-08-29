package com.portfoliogerez.leg.Service;

import com.portfoliogerez.leg.Entity.Objetivo;
import com.portfoliogerez.leg.Repository.RObjetivo;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SObjetivo {

    @Autowired
    RObjetivo rObjetivo;

    public Optional<Objetivo> getOne(int id) {
        return rObjetivo.findById(id);
    }

    public void save(Objetivo obj) {
        rObjetivo.save(obj);
    }

}
