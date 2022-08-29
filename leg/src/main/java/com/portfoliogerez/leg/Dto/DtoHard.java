package com.portfoliogerez.leg.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoHard {

    private String tituloH;
    private String descripcionH;
    private int porcentajeH;

    public DtoHard() {
    }

    public DtoHard(String tituloH, String descripcionH, int porcentajeH) {
        this.tituloH = tituloH;
        this.descripcionH = descripcionH;
        this.porcentajeH = porcentajeH;
    }

}
