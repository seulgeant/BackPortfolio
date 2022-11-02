package com.portfoliogerez.leg.Controller;

import com.portfoliogerez.leg.Dto.DtoProyecto;
import com.portfoliogerez.leg.Entity.Proyecto;
import com.portfoliogerez.leg.Service.SProyecto;
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
@RequestMapping("proyecto")
//@CrossOrigin(origins = "http://localhost:4200/")
//@CrossOrigin(origins = "https://leg-portfolio.web.app/")
@CrossOrigin(origins = {"http://localhost:4200","https://leg-portfolio.web.app"})

public class ProyectoController {

    @Autowired
    SProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproy) {

        if (sProyecto.existsByNombreP(dtoproy.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese Proyecto Existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoproy.getNombreP(), dtoproy.getFechaP(), dtoproy.getDescripcionP(), dtoproy.getUrl(), dtoproy.getEmpresaP());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoproy) {

        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        if (sProyecto.existsByNombreP(dtoproy.getNombreP())&& sProyecto.getbyNombreP(dtoproy.getNombreP()).get().getId()!=id) {
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreP(dtoproy.getNombreP());
        proyecto.setFechaP(dtoproy.getFechaP());
        proyecto.setDescripcionP(dtoproy.getDescripcionP());
        proyecto.setUrl(dtoproy.getUrl());
        proyecto.setEmpresaP(dtoproy.getEmpresaP());

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);

    }
  
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

}
