package com.example.mobileleweb.repo;
import com.example.mobileleweb.domain.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends JpaRepository<Brand , String> {
}


