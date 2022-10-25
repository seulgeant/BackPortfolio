package com.portfoliogerez.leg.Controller;

import com.portfoliogerez.leg.Dto.DtoObjetivo;
import com.portfoliogerez.leg.Entity.Objetivo;
import com.portfoliogerez.leg.Service.SObjetivo;
import com.portfoliogerez.leg.mensaje.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("objetivo")
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "https://leg-portfolio.web.app/")
public class ObjetivoController {

    @Autowired
    SObjetivo sObjetivo;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody DtoObjetivo dtoobj) {

        Objetivo objetivo = sObjetivo.getOne(1).get();
        objetivo.setDescripcionE(dtoobj.getDescripcionE());
        objetivo.setDescripcionM(dtoobj.getDescripcionM());
        objetivo.setDescripcionF(dtoobj.getDescripcionF());

        sObjetivo.save(objetivo);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);

    }

    @GetMapping("/detail")
    public ResponseEntity<Objetivo> getById() {
        Objetivo objetivo = sObjetivo.getOne(1).get();
        return new ResponseEntity(objetivo, HttpStatus.OK);
    }
}
