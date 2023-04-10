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
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String descripcionM;
    @NotBlank
    private String descripcionF;

    public Objetivo() {
    }

    public Objetivo(String descripcionE, String descripcionM, String descripcionF) {

        this.descripcionE = descripcionE;

        this.descripcionM = descripcionM;

        this.descripcionF = descripcionF;
    }

}
