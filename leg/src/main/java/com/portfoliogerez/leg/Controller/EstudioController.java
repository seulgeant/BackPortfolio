package com.portfoliogerez.leg.Controller;

import com.portfoliogerez.leg.Dto.DtoEstudio;
import com.portfoliogerez.leg.Entity.Estudio;
import com.portfoliogerez.leg.Service.SEstudio;

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
@RequestMapping("estudio")
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "https://leg-portfolio.web.app/")
public class EstudioController {

    @Autowired
    SEstudio sEstudio;

    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list() {
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEstudio dtoest) {

        Estudio estudio = new Estudio(dtoest.getNivel(), dtoest.getInstitucion(), dtoest.getTitulo(), dtoest.getDesde(), dtoest.getHasta(), dtoest.getEstado(), dtoest.getImgest());
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio Agregado"), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEstudio dtoest) {

        if (!sEstudio.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        Estudio estudio = sEstudio.getOne(id).get();
        estudio.setInstitucion(dtoest.getInstitucion());
        estudio.setNivel(dtoest.getNivel());
        estudio.setTitulo(dtoest.getTitulo());
        estudio.setDesde(dtoest.getDesde());
        estudio.setHasta(dtoest.getHasta());
        estudio.setEstado(dtoest.getEstado());
        estudio.setImgest(dtoest.getImgest());

        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio Actualizado"), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEstudio.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sEstudio.delete(id);
        return new ResponseEntity(new Mensaje("Estudio Eliminado"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id) {
        if (!sEstudio.existsById(id)) {
            return new ResponseEntity(new Mensaje("el estudio no existe"), HttpStatus.NOT_FOUND);
        }
        Estudio estudio = sEstudio.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
}
