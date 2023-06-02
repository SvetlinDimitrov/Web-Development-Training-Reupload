package com.example.mobileleweb.service.Model;

import com.example.mobileleweb.repo.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
}
