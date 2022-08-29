package com.portfoliogerez.leg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank
    private String nivel;
    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;
    @NotBlank
    private String desde;
    @NotBlank
    private String hasta;
    @NotBlank
    private String estado;

    private String imgest;

    public Estudio() {
    }

    public Estudio(String nivel, String institucion, String titulo, String desde, String hasta, String estado, String imgest) {
        this.nivel = nivel;
        this.institucion = institucion;
        this.titulo = titulo;
        this.desde = desde;
        this.hasta = hasta;
        this.estado = estado;
        this.imgest = imgest;
    }

}
