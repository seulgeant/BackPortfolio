package com.portfoliogerez.leg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Soft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String tituloS;
    @NotBlank
    private String descripcionS;
    @NotNull
    private int porcentajeS;

    public Soft() {
    }

    public Soft(String tituloS, String descripcionS, int porcentajeS) {
        this.tituloS = tituloS;
        this.descripcionS = descripcionS;
    }

}
