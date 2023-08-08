package com.example.pathfinder.service.picture;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.example.pathfinder.domain.dtos.UploadPictureDto;
import com.example.pathfinder.domain.entity.Route;
import com.example.pathfinder.domain.entity.UserEntity;
import com.example.pathfinder.repos.PictureRepository;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.repos.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PictureServiceImplTest {

    @Mock
    private PictureRepository pictureRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RouteRepository routeRepository;
    @Mock
    private UploadPictureDto picture;
    @Mock
    private Cloudinary cloudinary;
    @InjectMocks
    private PictureServiceImpl pictureService;

    private final static Long VALID_ID = 1L;
    private final static Long INVALID_ID = 3L;

    @BeforeEach
    public void setUp(){

        when(cloudinary.uploader()).thenReturn(mock(Uploader.class));

        when(picture.getPicture()).thenReturn(mock(MultipartFile.class));

    }

    @Test
    public void savePictureTest_ReturnTrueForCorrectInput() {

        when(userRepository.findById(VALID_ID)).thenReturn(Optional.of(mock(UserEntity.class)));
        when(routeRepository.findById(VALID_ID)).thenReturn(Optional.of(mock(Route.class)));

        assertTrue(pictureService.savePicture(picture, VALID_ID, VALID_ID));

    }

    @Test
    public void savePictureTest_ReturnFallsForInvalidInput() {

        when(userRepository.findById(INVALID_ID)).thenReturn(null);
        when(routeRepository.findById(INVALID_ID)).thenReturn(null);

        when(userRepository.findById(VALID_ID)).thenReturn(Optional.of(mock(UserEntity.class)));

        assertFalse(pictureService.savePicture(picture, VALID_ID, INVALID_ID));
        assertFalse(pictureService.savePicture(picture, INVALID_ID, VALID_ID));

    }


}