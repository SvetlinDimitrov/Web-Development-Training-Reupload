package com.example.pathfinder.service.picture;

import com.example.pathfinder.domain.dtos.UploadPictureDto;

import java.io.IOException;

public interface PictureService {
    boolean savePicture(UploadPictureDto picture, Long userId, Long routeId);
}
