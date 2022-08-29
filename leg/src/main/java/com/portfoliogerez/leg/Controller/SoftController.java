package com.portfoliogerez.leg.Controller;

import com.portfoliogerez.leg.Dto.DtoSoft;
import com.portfoliogerez.leg.Entity.Soft;
import com.portfoliogerez.leg.Service.SSoft;
import com.portfoliogerez.leg.mensaje.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("soft")
@CrossOrigin(origins = "http://localhost:4200/")

public class SoftController {

    @Autowired
    SSoft sSoft;

    @GetMapping("/lista")
    public ResponseEntity<List<SoftController>> list() {
        List<Soft> list = sSoft.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSoft dtosoft) {

        if (sSoft.existsByTituloS(dtosoft.getTituloS())) {
            return new ResponseEntity(new Mensaje("Esa Habilidad Existe"), HttpStatus.BAD_REQUEST);
        }

        Soft soft = new Soft(dtosoft.getTituloS(), dtosoft.getDescripcionS(), dtosoft.getPorcentajeS());
        sSoft.save(soft);
        return new ResponseEntity(new Mensaje("Habilidad Agregada"), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSoft dtosoft) {

        if (!sSoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        if (sSoft.existsByTituloS(dtosoft.getTituloS())&& sSoft.getbyTituloS(dtosoft.getTituloS()).get().getId()!=id) {
            return new ResponseEntity(new Mensaje("Esa Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        Soft soft = sSoft.getOne(id).get();
        soft.setTituloS(dtosoft.getTituloS());
        soft.setDescripcionS(dtosoft.getDescripcionS());
        soft.setPorcentajeS(dtosoft.getPorcentajeS());

        sSoft.save(soft);
        return new ResponseEntity(new Mensaje("Habilidad Actualizada"), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sSoft.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Soft> getById(@PathVariable("id") int id) {
        if (!sSoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Soft soft = sSoft.getOne(id).get();
        return new ResponseEntity(soft, HttpStatus.OK);
    }

}
