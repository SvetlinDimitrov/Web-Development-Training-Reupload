package com.example.mobileleweb.service.Brand;

import com.example.mobileleweb.repo.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;
}
