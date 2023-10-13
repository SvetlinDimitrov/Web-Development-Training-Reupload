package com.resellerapp.controller;

import com.resellerapp.config.UserPrincipal;
import com.resellerapp.model.dtos.OfferAddDto;
import com.resellerapp.service.OfferService;
import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Data
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    public ModelAndView addOffer(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("offerDto" , new OfferAddDto());
        modelAndView.setViewName("offer-add");

        return modelAndView;
    }

    @PostMapping
    public ModelAndView addOffer(@Valid @ModelAttribute (value = "offerDto") OfferAddDto offerAddDto ,
                                 BindingResult result ,
                                 ModelAndView modelAndView ,
                                 @AuthenticationPrincipal UserPrincipal user){

        if(result.hasErrors()){
            modelAndView.addObject("offerDto" , offerAddDto);
            modelAndView.setViewName("offer-add");
            return modelAndView;
        }
        offerService.saveOffer(user.getId() , offerAddDto);
        modelAndView.setViewName("redirect:" + "/user");
        return modelAndView;
    }

    @GetMapping("/buy/{offerId}/{sellerId}")
    public  ModelAndView buyOffer(@PathVariable Long offerId,
                                  @PathVariable Long sellerId ,
                                  @AuthenticationPrincipal UserPrincipal userPrincipal){
        offerService.buyOffer(offerId , sellerId , userPrincipal.getId());
        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/remove/{offerId}")
    public  ModelAndView buyOffer(@PathVariable Long offerId,
                                  @AuthenticationPrincipal UserPrincipal userPrincipal){
        offerService.removeOffer(offerId , userPrincipal.getId());
        return new ModelAndView("redirect:/user");
    }
}
