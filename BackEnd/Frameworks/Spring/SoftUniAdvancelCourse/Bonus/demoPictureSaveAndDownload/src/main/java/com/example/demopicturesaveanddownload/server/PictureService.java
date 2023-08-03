package com.example.demopicturesaveanddownload.server;

import com.example.demopicturesaveanddownload.model.dtos.DtoPicture;
import com.example.demopicturesaveanddownload.model.entity.PictureEntity;
import com.example.demopicturesaveanddownload.repos.PictureRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PictureService {
    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public Long savePicture(DtoPicture dto) throws IOException {
        PictureEntity save = pictureRepository.save(toPicture(dto));
        return save.getId();
    }

    public PictureEntity getById(Long id){
        return pictureRepository.findById(id).orElseThrow(NullPointerException::new);
    }



    public List<PictureEntity> getAllPictures() {
        return pictureRepository.findAll();
    }

    private PictureEntity toPicture(DtoPicture dto) throws IOException {
        return new PictureEntity()
                .setName(dto.getFile().getName())
                .setFile(dto.getFile().getBytes())
                .setContentType(dto.getFile().getContentType());
    }

}
