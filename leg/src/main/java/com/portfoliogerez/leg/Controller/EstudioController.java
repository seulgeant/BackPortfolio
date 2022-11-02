package com.portfoliogerez.leg.Controller;

import com.portfoliogerez.leg.Dto.DtoEstudio;
import com.portfoliogerez.leg.Entity.Estudio;
//import com.portfoliogerez.leg.Entity.ImageModel;
import com.portfoliogerez.leg.Service.SEstudio;
//import com.portfoliogerez.leg.Service.SImageModel;

import com.portfoliogerez.leg.mensaje.Mensaje;
//import com.portfoliogerez.leg.mensaje.ResponseMessage;
//import java.io.IOException;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("estudio")
//@CrossOrigin(origins = "http://localhost:4200/")
//CrossOrigin(origins = "https://leg-portfolio.web.app/")
@CrossOrigin(origins = {"http://localhost:4200","https://leg-portfolio.web.app"})
public class EstudioController {

    @Autowired
    SEstudio sEstudio;
 /*     @Autowired
  private SImageModel storageService;*/

    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list() {
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    
    /*@PostMapping(value={"/create"},consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
   public ResponseEntity<?> create(@RequestBody DtoEstudio dtoest) {
    public ResponseEntity<?> create(@RequestPart("imageFile")MultipartFile[] file,
                                    @RequestPart("dtoest")Estudio dtoest){
    
        try{
        Set<ImageModel> images=uploadImage(file);
      
        dtoest.setEstudioImages(images);
        Estudio estudio = new Estudio(dtoest.getNivel(), dtoest.getInstitucion(), dtoest.getTitulo(), dtoest.getDesde(), dtoest.getHasta(), dtoest.getEstado(), dtoest.getImgest(),dtoest.getEstudioImages());
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio Agregado"), HttpStatus.OK);
        }catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }*/

   
    
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody DtoEstudio dtoest) {     
       
        Estudio estudio = new Estudio(dtoest.getNivel(), dtoest.getInstitucion(), dtoest.getTitulo(), dtoest.getDesde(), dtoest.getHasta(), dtoest.getEstado(), dtoest.getImgest(),dtoest.getNameImg());
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio Agregado"), HttpStatus.OK);
        }
    

    
/*    public Set<ImageModel>uploadImage(MultipartFile[] multipartFiles)throws IOException{
    Set<ImageModel> imageModels=new HashSet<>();
    
    for (MultipartFile file: multipartFiles){
    ImageModel imageModel=new ImageModel(
    file.getOriginalFilename(),
    file.getContentType(),
    file.getBytes()
    );
    imageModels.add(imageModel);
    
            }
    return imageModels;
    }
*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEstudio dtoest) {

        if (!sEstudio.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }

        Estudio estudio = sEstudio.getOne(id).get();
        estudio.setInstitucion(dtoest.getInstitucion());
        estudio.setNivel(dtoest.getNivel());
        estudio.setTitulo(dtoest.getTitulo());
        estudio.setDesde(dtoest.getDesde());
        estudio.setHasta(dtoest.getHasta());
        estudio.setEstado(dtoest.getEstado());
        estudio.setImgest(dtoest.getImgest());
        estudio.setNameImg(dtoest.getNameImg());
        
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio Actualizado"), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEstudio.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no Existe"), HttpStatus.BAD_REQUEST);
        }
        sEstudio.delete(id);
        return new ResponseEntity(new Mensaje("Estudio Eliminado"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id) {
        if (!sEstudio.existsById(id)) {
            return new ResponseEntity(new Mensaje("el estudio no existe"), HttpStatus.NOT_FOUND);
        }
        Estudio estudio = sEstudio.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
}
