package com.example.mobilelegraderebuild.service.Model;

import com.example.mobilelegraderebuild.domain.constants.ModelCategory;
import com.example.mobilelegraderebuild.domain.entity.Brand;
import com.example.mobilelegraderebuild.domain.entity.Model;
import com.example.mobilelegraderebuild.domain.viewDtos.ViewModel;
import com.example.mobilelegraderebuild.repo.ModelRepository;
import com.example.mobilelegraderebuild.service.Brand.BrandService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModelServiceImplTest {

    @Mock
    private ModelRepository modelRepository;
    @Mock
    private BrandService brandService;

    @InjectMocks
    private ModelServiceImpl modelService;

    private final static List<Model> listModels = new ArrayList<>();
    private final static List<ViewModel> listViewModels = new ArrayList<>();

    private final static String VALID_ID = "VALID";
    private final static String NOT_VALID_ID = "NOT_VALID";

    @BeforeEach
    void setUp() {
        Brand testBrand = Brand.builder().name("zatesta").build();
        testBrand.setId(VALID_ID);
        listModels.addAll(List.of(
                        Model.builder()
                                .name("test")
                                .category(ModelCategory.Car)
                                .imageUrl("url")
                                .startYear(1999)
                                .endYear(2001)
                                .created(LocalDate.parse("2018-10-23"))
                                .modified(LocalDate.parse("2018-11-23"))
                                .brand(testBrand)
                                .build(),
                        Model.builder()
                                .name("test2")
                                .category(ModelCategory.Car)
                                .imageUrl("url2")
                                .startYear(1999)
                                .endYear(2001)
                                .created(LocalDate.parse("2018-10-23"))
                                .modified(LocalDate.parse("2018-11-23"))
                                .brand(testBrand)
                                .build(),
                        Model.builder()
                                .name("test3")
                                .category(ModelCategory.Car)
                                .imageUrl("url3")
                                .startYear(1999)
                                .endYear(2001)
                                .created(LocalDate.parse("2018-10-23"))
                                .modified(LocalDate.parse("2018-11-23"))
                                .brand(testBrand)
                                .build()
                )
        );

        listViewModels.addAll(List.of(
                        ViewModel.builder()
                                .id("0")
                                .name("test")
                                .category(ModelCategory.Car)
                                .imageUrl("url")
                                .startYear(1999)
                                .endYear(2001)
                                .created(LocalDate.parse("2018-10-23"))
                                .modified(LocalDate.parse("2018-11-23"))
                                .brand(testBrand)
                                .build(),
                        ViewModel.builder()
                                .id("1")
                                .name("test2")
                                .category(ModelCategory.Car)
                                .imageUrl("url2")
                                .startYear(1999)
                                .endYear(2001)
                                .created(LocalDate.parse("2018-10-23"))
                                .modified(LocalDate.parse("2018-11-23"))
                                .brand(testBrand)
                                .build(),
                        ViewModel.builder()
                                .id("2")
                                .name("test3")
                                .category(ModelCategory.Car)
                                .imageUrl("url3")
                                .startYear(1999)
                                .endYear(2001)
                                .created(LocalDate.parse("2018-10-23"))
                                .modified(LocalDate.parse("2018-11-23"))
                                .brand(testBrand)
                                .build()
                )
        );
        listModels.get(0).setId("0");
        listModels.get(1).setId("1");
        listModels.get(2).setId("2");
    }

    @AfterEach
    public void clear(){
        listModels.clear();
        listViewModels.clear();
    }

    @Test
    void getAllModelsWithCorrespondingModelsTest_CorrectlyReturnTheViews() {
        when(modelRepository.findAll()).thenReturn(listModels);

        Map<String , List<ViewModel>> expected = new HashMap<>();

        listViewModels.forEach(m-> {
            expected.putIfAbsent(m.getBrand().getName() , new ArrayList<>());
            expected.get(m.getBrand().getName()).add(m);
        });

        Map<String, List<ViewModel>> result = modelService.getAllModelsWithCorrespondingModels();

        assertEquals(expected , result);

    }

    @Test
    void getRandomModelTest_ReturnNonModifiedModel() {
        Model expected = listModels.get(0);
        when(modelRepository.getRandomModel()).thenReturn(expected);

        Model result = modelService.getRandomModel();

        assertEquals(expected, result);
    }

    @Test
    void getAllModels_ReturnTheViewModelWIthTheRightConversion() {
        when(modelRepository.findAll()).thenReturn(listModels);

        List<ViewModel> result = modelService.getAllModels();

        assertEquals(listViewModels , result);
    }

    @Test
    void findById_ReturnTheCorrectModel() {
        Model expected = listModels.get(0);
        when(modelRepository.findById(VALID_ID)).thenReturn(Optional.of(expected));

        Model result = modelService.findById(VALID_ID);

        assertEquals(expected, result);
    }

    @Test
    void findById_ThrowExceptionForNonExistingModel() {
        when(modelRepository.findById(NOT_VALID_ID)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> modelService.findById(NOT_VALID_ID));
    }
}