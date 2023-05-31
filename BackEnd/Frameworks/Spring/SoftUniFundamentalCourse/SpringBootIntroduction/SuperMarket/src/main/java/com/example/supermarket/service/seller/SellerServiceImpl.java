package com.example.supermarket.service.seller;

import com.example.supermarket.repos.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SellerServiceImpl implements SellerService {
    private SellerRepository sellerRepository;
}
