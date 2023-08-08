package com.example.mobileleweb.service.Model;

import com.example.mobileleweb.domain.constants.ModelCategory;
import com.example.mobileleweb.domain.entity.Model;
import com.example.mobileleweb.domain.viewDtos.ViewModel;
import com.example.mobileleweb.repo.ModelRepository;
import com.example.mobileleweb.service.Brand.BrandService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
    private BrandService brandService;

    @PostConstruct
    public void init(){
        if(modelRepository.findAll().isEmpty()){
            modelRepository.saveAll(
                    List.of(
                            Model.builder()
                                    .name("aSansor")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Altera"))
                                    .build(),
                            Model.builder()
                                    .name("kotka")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Altera"))
                                    .build(),
                            Model.builder()
                                    .name("asdaddddd")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("BWM"))
                                    .build(),
                            Model.builder()
                                    .name("BWM")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("BWM"))
                                    .build(),
                            Model.builder()
                                    .name("kotka")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("BWM"))
                                    .build()
                            ,Model.builder()
                                    .name("kuche")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("BWM"))
                                    .build()
                            ,Model.builder()
                                    .name("assansori")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Altera"))
                                    .build()
                            ,Model.builder()
                                    .name("aSansor")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Altera"))
                                    .build()
                            ,Model.builder()
                                    .name("aSaasdasdnsor")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Altera"))
                                    .build()
                            ,Model.builder()
                                    .name("asdasdasdasd")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Altera"))
                                    .build()
                            ,Model.builder()
                                    .name("kashoni")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Suzuki"))
                                    .build()
                            ,Model.builder()
                                    .name("hkljkljk")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Suzuki"))
                                    .build()
                            ,Model.builder()
                                    .name("asdasdasd")
                                    .category(ModelCategory.Car)
                                    .imageUrl("https://cdn.mos.cms.futurecdn.net/AvYjBAUeyfzsWRBDMFdieM.jpeg")
                                    .startYear(23)
                                    .endYear(50)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .brand(brandService.findByName("Suzuki"))
                                    .build()
                    )
            );
        }
    }

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
