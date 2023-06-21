package com.example.pathfinder.service.picture;

import com.example.pathfinder.repos.PictureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {
    private PictureRepository pictureRepository;
}
