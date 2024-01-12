package com.example.supermarket.repos;

import com.example.supermarket.domain.entity.Seller;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {
    Optional<Seller> findByFirstNameAndLastName(String firstName , String lastName);

    @Modifying
    @Transactional
    @Query("update Seller s set s.manager = :manager where s.id = :id")
    void setManager( String id, Seller manager);
}
