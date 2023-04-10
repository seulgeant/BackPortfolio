package com.portfoliogerez.leg.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoExperiencia {

    private String empresaE;
    private String cargoE;
    private String desdeE;
    private String hastaE;
    private String domicilioE;
    private String descripcionE;
    private String imgE;
    private String nImg;
    public DtoExperiencia() {
    }

    public DtoExperiencia(String empresaE, String cargoE, String desdeE, String hastaE, String domicilioE, String descripcionE, String imgE,String nImg) {
        this.empresaE = empresaE;
        this.cargoE = cargoE;
        this.desdeE = desdeE;
        this.hastaE = hastaE;
        this.domicilioE = domicilioE;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
        this.nImg=nImg;
    }

}
