package com.example.pathfinder.service.picture;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.pathfinder.domain.dtos.UploadPictureDto;
import com.example.pathfinder.domain.entity.Picture;
import com.example.pathfinder.repos.PictureRepository;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {
    private PictureRepository pictureRepository;
    private UserRepository userRepository;
    private RouteRepository routeRepository;
    private Cloudinary cloudinary;

    @Override
    public boolean savePicture(UploadPictureDto picture, Long userId, Long routeId){
        try{
            Picture pictureEntity = toPicture(picture , userId , routeId);
            pictureRepository.save(pictureEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private Picture toPicture(UploadPictureDto picture, Long userId, Long routeId) throws IOException {

        Map<String, String> uploadResult =
                cloudinary
                        .uploader()
                        .upload(picture.getPicture().getBytes(), ObjectUtils.emptyMap());

        return Picture.builder()
                .title(picture.getPicture().getName())
                .author(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("No user existed with that id")))
                .route(routeRepository.findById(routeId).orElseThrow(() -> new RuntimeException("No route existed with that id")))
                .url(uploadResult.get("secure_url"))
                .build();
    }
}
