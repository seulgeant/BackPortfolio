package com.portfoliogerez.leg.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String nacimiento;
    @NotBlank
    private String dni;
    @NotBlank
    private String cuil;
    @NotBlank
    private String civil;
    @NotNull
    private int hijos;
    @NotBlank
    private String domicilio;
    @NotBlank
    private String telefono;
    @NotBlank
    private String correo;
    @NotBlank
    private String titulo;
    @NotBlank
    private String acercade;
    
    private String img;



    public Persona() {
        super();
    }

    public Persona(String nombre, String apellido, String nacimiento, String dni, String cuil, String civil, int hijos, String img, String domicilio, String telefono, String correo, String titulo, String acercade) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.dni = dni;
        this.cuil = cuil;
        this.civil = civil;
        this.hijos = hijos;
        this.img = img;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.correo = correo;
        this.titulo = titulo;
        this.acercade = acercade;

    }

}
