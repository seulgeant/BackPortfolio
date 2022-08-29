package com.portfoliogerez.leg.Controller;

import com.portfoliogerez.leg.Dto.DtoHard;
import com.portfoliogerez.leg.Entity.Hard;
import com.portfoliogerez.leg.Service.SHard;
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
@RequestMapping("hard")
@CrossOrigin(origins = "http://localhost:4200/")
public class HardController {

    @Autowired
    SHard sHard;

    
    @GetMapping("/lista")
    public ResponseEntity<List<SoftController>> list() {
        List<Hard> list = sHard.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

   
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHard dtohard) {

        if (sHard.existsByTituloH(dtohard.getTituloH())) {
            return new ResponseEntity(new Mensaje("Esa Habilidad Existe"), HttpStatus.BAD_REQUEST);
        }

        Hard hard = new Hard(dtohard.getTituloH(), dtohard.getDescripcionH(), dtohard.getPorcentajeH());
        sHard.save(hard);
        return new ResponseEntity(new Mensaje("Habilidad Agregada"), HttpStatus.OK);
    }

 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHard dtohard) {

        if (!sHard.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        if (sHard.existsByTituloH(dtohard.getTituloH())&& sHard.getbyTituloH(dtohard.getTituloH()).get().getId()!=id) {
            return new ResponseEntity(new Mensaje("Esa Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        Hard hard = sHard.getOne(id).get();
        hard.setTituloH(dtohard.getTituloH());
        hard.setDescripcionH(dtohard.getDescripcionH());
        hard.setPorcentajeH(dtohard.getPorcentajeH());

        sHard.save(hard);
        return new ResponseEntity(new Mensaje("Habilidad Actualizada"), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHard.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sHard.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hard> getById(@PathVariable("id") int id) {
        if (!sHard.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Hard hard = sHard.getOne(id).get();
        return new ResponseEntity(hard, HttpStatus.OK);
    }

}
