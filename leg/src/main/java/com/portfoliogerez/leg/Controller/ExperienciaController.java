package com.portfoliogerez.leg.Controller;

import com.portfoliogerez.leg.Dto.DtoExperiencia;
import com.portfoliogerez.leg.Entity.Experiencia;
import com.portfoliogerez.leg.Service.SExperiencia;
import com.portfoliogerez.leg.mensaje.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200/")
public class ExperienciaController {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

 
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp) {

        Experiencia experiencia = new Experiencia(dtoexp.getEmpresaE(), dtoexp.getCargoE(), dtoexp.getDesdeE(), dtoexp.getHastaE(), dtoexp.getDomicilioE(), dtoexp.getDescripcionE(), dtoexp.getImgE());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp) {

        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setEmpresaE(dtoexp.getEmpresaE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        experiencia.setCargoE(dtoexp.getCargoE());
        experiencia.setDesdeE(dtoexp.getDesdeE());
        experiencia.setHastaE(dtoexp.getHastaE());
        experiencia.setDomicilioE(dtoexp.getDomicilioE());
        experiencia.setImgE(dtoexp.getImgE());

        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe la experiencia"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
