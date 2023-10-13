package com.resellerapp.model.dtos;

import com.resellerapp.model.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ViewUser {

    private Long id;
    private String username;
    private String email;
    private List<ViewOffer> offers;
    private List<ViewOffer> boughtOffers;

    public ViewUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.offers = user.getOffers().stream().map(ViewOffer::new).collect(Collectors.toList());
        this.boughtOffers = user.getBoughtOffers().stream().map(ViewOffer::new).collect(Collectors.toList());
    }
}
