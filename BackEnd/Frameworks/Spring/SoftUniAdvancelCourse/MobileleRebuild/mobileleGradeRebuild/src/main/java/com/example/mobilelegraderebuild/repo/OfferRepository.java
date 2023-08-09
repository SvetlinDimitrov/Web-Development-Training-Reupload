package com.example.mobilelegraderebuild.repo;

import com.example.mobilelegraderebuild.domain.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
}
