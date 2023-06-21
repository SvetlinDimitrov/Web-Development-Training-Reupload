package com.example.mobileleweb.service.Model;

import com.example.mobileleweb.domain.entity.Model;
import com.example.mobileleweb.domain.viewDtos.ViewModel;

import java.util.List;
import java.util.Map;

public interface ModelService {
    Map<String, List<ViewModel>> getAllModelsWithCorrespondingModels();

    Model getRandomModel();

    List<ViewModel> getAllModels();

    Model findById(String modelId);
}
