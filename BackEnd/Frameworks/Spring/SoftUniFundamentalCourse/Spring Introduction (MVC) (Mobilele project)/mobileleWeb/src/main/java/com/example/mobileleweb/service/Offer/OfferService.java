package com.example.mobileleweb.service.Offer;

import com.example.mobileleweb.domain.viewDtos.ViewOfferDto;

import java.util.List;

public interface OfferService {
    List<ViewOfferDto> getAllOffers();

    void addOffer(ViewOfferDto offerView);

    ViewOfferDto getViewOfferById(String id);

    void updateOffer(ViewOfferDto viewOfferDto);

    void deleteOffer(String id);
}
