package com.example.supermarket.service.shop;

import com.example.supermarket.repos.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {
    private ShopRepository shopRepository;
}
