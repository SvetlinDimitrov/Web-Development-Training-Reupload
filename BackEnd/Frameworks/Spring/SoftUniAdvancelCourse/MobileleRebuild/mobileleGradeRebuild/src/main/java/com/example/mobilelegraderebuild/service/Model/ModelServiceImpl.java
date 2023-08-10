package com.example.mobilelegraderebuild.service.Model;

import com.example.mobilelegraderebuild.domain.entity.Model;
import com.example.mobilelegraderebuild.domain.viewDtos.ViewModel;
import com.example.mobilelegraderebuild.repo.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;

    @Override
    public Map<String, List<ViewModel>> getAllModelsWithCorrespondingModels() {

        List<Model> models = modelRepository.findAll();
        Map<String , List<ViewModel>> map = new HashMap<>();

        models.forEach(m-> {
            map.putIfAbsent(m.getBrand().getName() , new ArrayList<>());
            map.get(m.getBrand().getName()).add(new ViewModel(m));
        });
        return map;
    }

    @Override
    public Model getRandomModel() {
        return modelRepository.getRandomModel();
    }

    @Override
    public List<ViewModel> getAllModels() {
        return modelRepository.findAll()
                .stream()
                .map(ViewModel::new)
                .toList();
    }

    @Override
    public Model findById(String modelId) {
        return modelRepository
                .findById(modelId)
                .orElseThrow(NoSuchElementException::new);
    }

}
