package com.portfoliogerez.leg.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSoft {

    private String tituloS;
    private String descripcionS;
    private int porcentajeS;

    public DtoSoft() {
    }

    public DtoSoft(String tituloS, String descripcionS, int porcentajeS) {
        this.tituloS = tituloS;
        this.descripcionS = descripcionS;
    }

}
