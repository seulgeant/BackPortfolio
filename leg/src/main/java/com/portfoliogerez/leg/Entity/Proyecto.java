package com.portfoliogerez.leg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank
    private String nombreP;
    @NotBlank
    private String fechaP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String url;
    @NotBlank
    private String empresaP;

    public Proyecto() {
    }

    public Proyecto(String nombreP, String fechaP, String descripcionP, String url, String empresaP) {
        this.nombreP = nombreP;
        this.fechaP = fechaP;
        this.descripcionP = descripcionP;
        this.url = url;
        this.empresaP = empresaP;
    }

}
