package com.example.labexercise.service.Model;

import com.example.labexercise.repo.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
}
