/*
package com.portfoliogerez.leg.Service;


import com.portfoliogerez.leg.Entity.ImageModel;

import com.portfoliogerez.leg.Repository.RImageModel;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class SImageModel {
        @Autowired
    RImageModel rImageModel;

    public ImageModel store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    ImageModel imageModel = new ImageModel(fileName, file.getContentType(), file.getBytes());

    return rImageModel.save(imageModel);
  }

  public ImageModel getFile(String id) {
    return rImageModel.findById(id).get();
  }
  
  public Stream<ImageModel> getAllFiles() {
    return rImageModel.findAll().stream();
  }
}
*/