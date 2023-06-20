package com.example.mobileleweb.service.Offer;

import com.example.mobileleweb.domain.viewDtos.ViewOffer;

import java.util.List;

public interface OfferService {
    List<ViewOffer> getAllOffers();

    void addOffer(ViewOffer offerView);

    ViewOffer getViewOfferById(String id);

    void updateOffer(ViewOffer viewOffer);

    void deleteOffer(String id);
}
