package com.example.mobilelegraderebuild.service.Offer;

import com.example.mobilelegraderebuild.domain.entity.Offer;
import com.example.mobilelegraderebuild.domain.viewDtos.ViewOfferDto;
import com.example.mobilelegraderebuild.repo.OfferRepository;
import com.example.mobilelegraderebuild.service.Model.ModelService;
import com.example.mobilelegraderebuild.service.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Component
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private ModelService modelService;
    private UserService userService;


    @Override
    public List<ViewOfferDto> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        return offers.stream()
                .map(Offer::toViewOffer)
                .toList();
    }

    @Override
    public void addOffer(ViewOfferDto offerView) {
        Offer offer = offerView.toOffer();
        offer.setModel(modelService.findById(offerView.getModelId()));
        offer.setSeller(userService.findById(offerView.getSellerId()));
        offerRepository.save(offer);
    }

    @Override
    public ViewOfferDto getViewOfferById(String id) {
        return offerRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new)
                .toViewOffer();
    }

    @Override
    public void updateOffer(ViewOfferDto offerView) {
        Offer offer = offerRepository.findById(offerView.getId()).orElseThrow(NoSuchElementException::new);
        offer.setDescription(offerView.getDescription());
        offer.setEngine(offerView.getEngine());
        offer.setImageUrl(offerView.getImageUrl());
        offer.setMileage(offerView.getMileage());
        offer.setPrice(offerView.getPrice());
        offer.setTransmission(offerView.getTransmission());
        offer.setYear(offerView.getYear());
        offer.setCreated(offerView.getCreated());
        offer.setModified(LocalDate.now());
        offer.setModel(modelService.findById(offerView.getModelId()));
        offer.setSeller(userService.findById(offerView.getSellerId()));
        offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(String id) {
        Offer offer = offerRepository.findById(id).orElseThrow(NoSuchElementException::new);
        offer.getSeller().getOffers().remove(offer);
        offerRepository.delete(offer);
    }


}
