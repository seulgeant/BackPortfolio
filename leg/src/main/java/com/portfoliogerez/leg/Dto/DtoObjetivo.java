package com.portfoliogerez.leg.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoObjetivo {


    private String descripcionE;
    private String descripcionM;
    private String descripcionF;

    public DtoObjetivo() {
    }

    public DtoObjetivo(String descripcionE, String descripcionM, String descripcionF) {

        this.descripcionE = descripcionE;
        this.descripcionM = descripcionM;
        this.descripcionF = descripcionF;
    }

}
