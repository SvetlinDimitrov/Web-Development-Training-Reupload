package com.example.supermarket.repos;

import com.example.supermarket.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
    Optional<Shop> findByName(String name);
}
