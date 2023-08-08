package com.example.mobileleweb.service.Brand;

import com.example.mobileleweb.domain.entity.Brand;
import com.example.mobileleweb.repo.BrandRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    @PostConstruct
    public void initBrands() {
        if (brandRepository.findAll().isEmpty()) {
            brandRepository.saveAll(List.of
                    (Brand.builder()
                                    .name("Suzuki")
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .build(),
                            Brand.builder()
                                    .name("Altera")
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .build(),
                            Brand.builder()
                                    .name("BWM")
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .build()
                    )
            );
        }
    }

    @Override
    public Brand findByName(String name) {
        return brandRepository.findByName(name).orElseThrow(NoSuchElementException::new);
    }
}
