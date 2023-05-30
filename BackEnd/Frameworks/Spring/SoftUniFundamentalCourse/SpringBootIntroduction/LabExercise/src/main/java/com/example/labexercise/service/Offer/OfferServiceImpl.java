package com.example.labexercise.service.Offer;

import com.example.labexercise.repo.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
}
