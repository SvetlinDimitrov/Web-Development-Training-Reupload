package com.example.supermarket.service.seller;

public interface SellerService {
    void add(String[] sellerInfo);

    void addManagerToSeller(String[] seller, String[] manager);
}
