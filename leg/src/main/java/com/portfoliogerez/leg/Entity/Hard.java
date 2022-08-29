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
public class Hard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank
    private String tituloH;
    @NotBlank
    private String descripcionH;
    @NotNull
    private int porcentajeH;

    public Hard() {
    }

    public Hard(String tituloH, String descripcionH, int porcentajeH) {
        this.tituloH = tituloH;
        this.descripcionH = descripcionH;
        this.porcentajeH = porcentajeH;
    }

}
