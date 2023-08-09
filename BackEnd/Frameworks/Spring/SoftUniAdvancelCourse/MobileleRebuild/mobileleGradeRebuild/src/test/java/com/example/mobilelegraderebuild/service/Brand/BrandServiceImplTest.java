package com.example.mobilelegraderebuild.service.Brand;

import com.example.mobilelegraderebuild.domain.entity.Brand;
import com.example.mobilelegraderebuild.repo.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandServiceImplTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandServiceImpl brandService;

    private final static String VALID_NAME = "valid";
    private final static String NOT_VALID_NAME = "notValid";


    @Test
    void findByNameTest_withValidName() {
        Brand brand = new Brand("yes", LocalDate.now(),LocalDate.now());
        when(brandRepository.findByName(VALID_NAME)).thenReturn(Optional.of(brand));

        Brand result = brandService.findByName(VALID_NAME);

        assertEquals(brand , result);

    }
    @Test
    void findByNameTest_withNotValidName() {

        when(brandRepository.findByName(NOT_VALID_NAME)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class , () -> brandService.findByName(NOT_VALID_NAME));

    }
}