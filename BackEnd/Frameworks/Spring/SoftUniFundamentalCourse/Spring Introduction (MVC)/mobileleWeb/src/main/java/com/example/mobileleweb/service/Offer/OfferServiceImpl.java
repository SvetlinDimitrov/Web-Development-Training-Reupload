package com.example.mobileleweb.service.Offer;

import com.example.mobileleweb.repo.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
}
