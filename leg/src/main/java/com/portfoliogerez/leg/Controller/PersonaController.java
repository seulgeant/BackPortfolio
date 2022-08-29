package com.portfoliogerez.leg.Controller;

import com.portfoliogerez.leg.Dto.DtoPersona;
import com.portfoliogerez.leg.Entity.Persona;
import com.portfoliogerez.leg.Service.SPersona;
import com.portfoliogerez.leg.mensaje.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
@CrossOrigin(origins = "http://localhost:4200/")

public class PersonaController {

    @Autowired
    SPersona sPersona;

 
    @PutMapping("/update")
    
    public ResponseEntity<?> update(@RequestBody DtoPersona dtopers) {
        
        
        
        Persona persona = sPersona.getOne(1).get();
        persona.setNombre(dtopers.getNombre());
        persona.setApellido(dtopers.getApellido());
        persona.setNacimiento(dtopers.getNacimiento());
        persona.setDni(dtopers.getDni());
        persona.setCuil(dtopers.getCuil());
        persona.setCivil(dtopers.getCivil());
        persona.setHijos(dtopers.getHijos());
        persona.setImg(dtopers.getImg());
        persona.setDomicilio(dtopers.getDomicilio());
        persona.setTelefono(dtopers.getTelefono());
        persona.setCorreo(dtopers.getCorreo());
        persona.setTitulo(dtopers.getTitulo());
        persona.setAcercade(dtopers.getAcercade());
        

        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);

    }

    @GetMapping("/detail")
    public ResponseEntity<Persona> getById() {
        Persona persona = sPersona.getOne(1).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
   
    
}
