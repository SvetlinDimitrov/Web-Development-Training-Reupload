package com.resellerapp.service;

import com.resellerapp.model.dtos.OfferAddDto;
import com.resellerapp.model.dtos.ViewOffer;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import lombok.Data;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ConditionRepository conditionRepository;

    @Transactional
    public void saveOffer(Long id, OfferAddDto offerAddDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("not user was found"));
        Offer offer = offerAddDto.toOffer();
        offer.setCondition
                (conditionRepository.findByName(offerAddDto.getCondition())
                        .orElseThrow((() -> new RuntimeException("няма такова нещо"))));
        offerRepository.save(offer);
        user.getOffers().add(offer);
        userRepository.save(user);
    }

    @Transactional
    public void buyOffer(Long offerId, Long sellerId, Long buyerId) {
        User seller = userRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("seller does not exist"));
        User buyer = userRepository.findById(buyerId).orElseThrow(() -> new RuntimeException("buyer does not exist"));
        Offer offer = offerRepository.findById(offerId).orElseThrow(() -> new RuntimeException("current offer does not exist"));

        buyer.getBoughtOffers().add(offer);
        userRepository.save(buyer);

        seller.getOffers().remove(offer);
        userRepository.save(seller);
    }

    @Transactional
    @Modifying
    public void removeOffer(Long offerId, Long userId) {
        User seller = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("seller does not exist"));
        Offer offer = offerRepository.findById(offerId).orElseThrow(() -> new RuntimeException("current offer does not exist"));

        seller.getOffers().remove(offer);
        userRepository.save(seller);

        offerRepository.delete(offer);
    }
}
