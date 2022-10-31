package com.portfoliogerez.leg.Dto;

//import com.portfoliogerez.leg.Entity.ImageModel;
//import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DtoEstudio {

    private String Nivel;
    private String Institucion;
    private String Titulo;
    private String desde;
    private String hasta;
    private String estado;
    private String imgest;
    private String nameImg;
  //  private Set<ImageModel> estudioImages;


    public DtoEstudio() {
    }

    public DtoEstudio(String Nivel, String Institucion, String Titulo, String desde, String hasta, String estado, String imgest,String nameImg ) {
        this.Nivel = Nivel;
        this.Institucion = Institucion;
        this.Titulo = Titulo;
        this.desde = desde;
        this.hasta = hasta;
        this.estado = estado;
        this.imgest = imgest;
 this.nameImg=nameImg;
        

    }

}