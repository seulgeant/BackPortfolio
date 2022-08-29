package com.portfoliogerez.leg.Entity;

import java.io.File;
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
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank
    private String empresaE;
    @NotBlank
    private String cargoE;
    @NotBlank
    private String desdeE;
    @NotBlank
    private String hastaE;
    @NotBlank
    private String domicilioE;
    @NotBlank
    private String descripcionE;
    private String imgE;

    public Experiencia() {
    }

    public Experiencia(String empresaE, String cargoE, String desdeE, String hastaE, String domicilioE, String descripcionE, String imgE) {
        this.empresaE = empresaE;
        this.cargoE = cargoE;
        this.desdeE = desdeE;
        this.hastaE = hastaE;
        this.domicilioE = domicilioE;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
    }

}
