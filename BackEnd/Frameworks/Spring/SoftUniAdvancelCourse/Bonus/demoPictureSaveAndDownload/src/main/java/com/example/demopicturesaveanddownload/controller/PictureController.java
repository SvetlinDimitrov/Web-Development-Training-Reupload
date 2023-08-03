package com.example.demopicturesaveanddownload.controller;

import com.example.demopicturesaveanddownload.model.dtos.DtoPicture;
import com.example.demopicturesaveanddownload.model.entity.PictureEntity;
import com.example.demopicturesaveanddownload.server.PictureService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }


    @GetMapping
    public ModelAndView getPicturePage(ModelAndView modelAndView) {
        modelAndView.addObject("image", new DtoPicture());
        modelAndView.setViewName("imgaeUpload.html");
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView createImage(DtoPicture image, ModelAndView modelAndView) throws IOException {
        modelAndView.setViewName("imgaeUpload.html");
        Long id = pictureService.savePicture(image);

        modelAndView.setViewName("redirect:/show/picture"+id);
        return modelAndView;
    }
    @GetMapping("/show/picture/{id}")
    public ModelAndView getViewImage(@PathVariable Long id , ModelAndView modelAndView) {
        modelAndView.addObject("fileId", id);
        modelAndView.setViewName("showSinglePicture.html");
        return modelAndView;
    }

    @GetMapping("/download/{id}")
    public HttpEntity<byte[]> getImage(@PathVariable Long id) {

        PictureEntity picture = pictureService.getById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MimeTypeUtils.parseMimeType(picture.getContentType())));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+picture.getName());
        headers.setContentLength(picture.getFile().length);

        return new HttpEntity<>(picture.getFile(), headers);

    }

    @GetMapping("/pictures/all")
    public ResponseEntity<List<byte[]>> getImage() {
        // Fetch the picture entity from the database
        List<PictureEntity> pictures = pictureService.getAllPictures();

        List<byte[]> imageData = pictures
                .stream()
                .map(PictureEntity::getFile)
                .toList();
        HttpHeaders headers = new HttpHeaders();
        // Set the appropriate Content-Type header for the image (e.g., image/jpeg, image/png, etc.)
        headers.setContentType(MediaType.IMAGE_JPEG); // Change this to the appropriate content type
        // Return the image data along with the Content-Type header
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);

    }
}
