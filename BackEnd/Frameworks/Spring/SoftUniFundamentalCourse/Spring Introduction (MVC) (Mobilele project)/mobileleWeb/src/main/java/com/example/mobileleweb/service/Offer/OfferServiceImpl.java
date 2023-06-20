package com.example.mobileleweb.service.Offer;

import com.example.mobileleweb.domain.constants.Engine;
import com.example.mobileleweb.domain.constants.Transmission;
import com.example.mobileleweb.domain.entity.Model;
import com.example.mobileleweb.domain.entity.Offer;
import com.example.mobileleweb.domain.viewDtos.ViewOffer;
import com.example.mobileleweb.repo.OfferRepository;
import com.example.mobileleweb.service.Model.ModelService;
import com.example.mobileleweb.service.User.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Component
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private ModelService modelService;
    private UserService userService;
    private ModelMapper mapper;


    @PostConstruct
    public void init(){
        if(offerRepository.findAll().isEmpty()){
            offerRepository.saveAll(
                    List.of(
                            Offer.builder()
                                    .description("prodava sa ot pesho za x 4ovek koito vqrva 4e silata idva ot masata")
                                    .engine(Engine.DIESEL)
                                    .mileage(559)
                                    .price(new BigDecimal("90000"))
                                    .transmission(Transmission.AUTOMATIC)
                                    .year(22)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .model(modelService.getRandomModel())
                                    .seller(userService.getUserByUsername("user"))
                                    .build().setImgToModelImg(),
                            Offer.builder()
                                    .description("proda idva ot masata")
                                    .engine(Engine.DIESEL)
                                    .mileage(23232323)
                                    .price(new BigDecimal("1231231231231231"))
                                    .transmission(Transmission.AUTOMATIC)
                                    .year(2323)
                                    .created(LocalDate.now())
                                    .modified(LocalDate.now())
                                    .model(modelService.getRandomModel())
                                    .seller(userService.getUserByUsername("admin"))
                                    .build().setImgToModelImg()
                    )
            );
        }
    }

    @Override
    public List<ViewOffer> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        return offers.stream()
                .map(Offer::toViewOffer)
                .toList();
    }

    @Override
    public void addOffer(ViewOffer offerView) {
        Offer offer = mapper.map(offerView, Offer.class);
        offer.setModel(modelService.findById(offerView.getModelId()));
        offer.setSeller(userService.findById(offerView.getSellerId()));
        offerRepository.save(offer);
    }

    @Override
    public ViewOffer getViewOfferById(String id) {
        return offerRepository.findById(id).get().toViewOffer();
    }

    @Override
    public void updateOffer(ViewOffer offerView) {
        Offer offer = offerRepository.findById(offerView.getId()).get();
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
        Offer offer = offerRepository.findById(id).get();
        offer.getSeller().getOffers().remove(offer);
        offerRepository.delete(offer);
    }


}
