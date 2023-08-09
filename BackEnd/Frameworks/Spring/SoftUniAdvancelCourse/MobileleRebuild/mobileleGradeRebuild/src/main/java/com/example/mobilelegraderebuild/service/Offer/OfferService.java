package com.example.mobilelegraderebuild.service.Offer;

import com.example.mobilelegraderebuild.domain.viewDtos.ViewOfferDto;

import java.util.List;

public interface OfferService {
    List<ViewOfferDto> getAllOffers();

    void addOffer(ViewOfferDto offerView);

    ViewOfferDto getViewOfferById(String id);

    void updateOffer(ViewOfferDto viewOfferDto);

    void deleteOffer(String id);
}
