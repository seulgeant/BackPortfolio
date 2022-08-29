package com.portfoliogerez.leg.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoProyecto {


    private String nombreP;
    private String fechaP;
    private String descripcionP;
    private String url;
    private String empresaP;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreP, String fechaP, String descripcionP, String url, String empresaP) {
        this.nombreP = nombreP;
        this.fechaP = fechaP;
        this.descripcionP = descripcionP;
        this.url = url;
        this.empresaP = empresaP;
    }

}
