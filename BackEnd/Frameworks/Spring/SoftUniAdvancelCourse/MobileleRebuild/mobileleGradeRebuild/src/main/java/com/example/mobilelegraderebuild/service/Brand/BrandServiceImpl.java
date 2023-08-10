package com.example.mobilelegraderebuild.service.Brand;

import com.example.mobilelegraderebuild.domain.entity.Brand;
import com.example.mobilelegraderebuild.repo.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    @Override
    public Brand findByName(String name) {
        return brandRepository.findByName(name).orElseThrow(NoSuchElementException::new);
    }
}
