package com.example.pathfinder.service.category;

import com.example.pathfinder.domain.bindingViews.ViewCategorie;
import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.repos.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository repository;

    private final Categorie category = new Categorie(1L , CategoryConstant.CAR , "description");;

    @Test
    public void TestGetAllCategories_CorrectlyMapToViewCategories(){
        when(repository.findAll()).thenReturn(List.of(category));

        List<ViewCategorie> expectedCategories = List.of(
                new ViewCategorie(1L, CategoryConstant.CAR,"description")
        );

        List<ViewCategorie> result = categoryService.getAllCategories();

        assertEquals(result.size(), expectedCategories.size());

        assertEquals(expectedCategories.get(0),  result.get(0));

    }

    @Test
    public void findByCategoryConstantTest_CorrectlyReturn(){
        when(repository.findByName(CategoryConstant.CAR)).thenReturn(Optional.of(category));

        Categorie result = categoryService.findByCategoryConstant(CategoryConstant.CAR);

        assertNotNull(result);
        assertEquals(result.getName() , CategoryConstant.CAR);
    }

}