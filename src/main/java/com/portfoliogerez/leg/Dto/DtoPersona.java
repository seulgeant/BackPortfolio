package com.portfoliogerez.leg.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPersona {


    private String nombre;
    private String apellido;
    private String nacimiento;
    private String dni;
    private String cuil;
    private String civil;
    private int hijos;
    private String img;
    private String domicilio;
    private String telefono;
    private String correo;
    private String titulo;
    private String acercade;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String nacimiento, String dni, String cuil, String civil, int hijos, String img, String domicilio, String telefono, String correo, String titulo, String acercade) {
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
