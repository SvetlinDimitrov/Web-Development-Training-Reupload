package com.example.productsshop.services.product;

import com.example.productsshop.entities.products.Product;
import com.example.productsshop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<Product> productsInRange() {
        return productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(new BigDecimal(500) , new BigDecimal(1500));
    }
}
