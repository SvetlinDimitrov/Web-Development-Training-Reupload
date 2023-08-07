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

    private final static Long VALID_USER_ID = 1L;
    private final static Long VALID_ROUTE_ID = 1L;
    private final static Long INVALID_ROUTE_ID = 3L;
    private final static Long INVALID_USER_ID = 3L;
    private final Map<String , String> map = new HashMap<>();

    @BeforeEach
    public void setUp() throws IOException {


        Uploader uploaderMock = mock(Uploader.class);
        when(cloudinary.uploader()).thenReturn(uploaderMock);
        when(uploaderMock.upload(notNull() , notNull())).thenReturn(map);

        MultipartFile multipartFile = mock(MultipartFile.class);
        when(picture.getPicture()).thenReturn(multipartFile);
        when(multipartFile.getBytes()).thenReturn(new byte[]{});

        UserEntity user = new UserEntity();
        Route route = new Route();
        when(userRepository.findById(VALID_USER_ID)).thenReturn(Optional.of(user));
        when(routeRepository.findById(VALID_ROUTE_ID)).thenReturn(Optional.of(route));

    }

    @Test
    public void savePictureTest_ReturnTrueForCorrectInput() {

        assertTrue(pictureService.savePicture(picture, VALID_USER_ID, VALID_ROUTE_ID));

    }

    @Test
    public void savePictureTest_ReturnFallsForInvalidInput() {



        boolean result = pictureService.savePicture(picture, VALID_USER_ID, INVALID_ROUTE_ID);
        boolean result1 = pictureService.savePicture(picture, INVALID_USER_ID, VALID_ROUTE_ID);

        assertFalse(result);
        assertFalse(result1);

    }


}