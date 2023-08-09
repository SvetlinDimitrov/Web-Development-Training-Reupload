package com.example.mobilelegraderebuild.service.Model;

import com.example.mobilelegraderebuild.domain.entity.Model;
import com.example.mobilelegraderebuild.domain.viewDtos.ViewModel;

import java.util.List;
import java.util.Map;

public interface ModelService {
    Map<String, List<ViewModel>> getAllModelsWithCorrespondingModels();

    Model getRandomModel();

    List<ViewModel> getAllModels();

    Model findById(String modelId);
}
