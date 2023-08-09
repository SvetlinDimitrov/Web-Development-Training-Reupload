package com.example.mobilelegraderebuild.web.controller;

import com.example.mobilelegraderebuild.domain.entity.UserEntity;
import com.example.mobilelegraderebuild.domain.viewDtos.ViewOfferDto;
import com.example.mobilelegraderebuild.domain.viewDtos.SecurityViewUser;
import com.example.mobilelegraderebuild.service.Model.ModelService;
import com.example.mobilelegraderebuild.service.Offer.OfferService;
import com.example.mobilelegraderebuild.service.User.UserService;
import com.example.mobilelegraderebuild.web.constants.BaseModelAndView;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/offers")
public class OfferController extends BaseModelAndView {

    private OfferService offerService;
    private ModelService modelService;
    private UserService userService;

    @GetMapping("/add")
    public ModelAndView getAddView(ModelAndView modelAndView) {
        modelAndView.addObject("allModels", modelService.getAllModels());
        modelAndView.addObject("offerView", new ViewOfferDto());
        return view("offer-add.html", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addOffer(@Valid @ModelAttribute(name = "offerView") ViewOfferDto offerView,
                                 BindingResult result,
                                 ModelAndView modelAndView,
                                 HttpSession session) {

        if (result.hasErrors()) {
            modelAndView.addObject("allModels", modelService.getAllModels());
            return view("offer-add.html", modelAndView);
        }
        SecurityViewUser user = (SecurityViewUser) session.getAttribute("user");
        offerView.setSellerId(user.getId());
        offerService.addOffer(offerView);
        return redirect("/offers/all", modelAndView);
    }


    @GetMapping("/all")
    public ModelAndView getAllView(ModelAndView modelAndView) {

        modelAndView.addObject("allOffers", offerService.getAllOffers());
        return view("offers.html", modelAndView);
    }

    @GetMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable(name = "id") String id,
                                   ModelAndView modelAndView) {

        ViewOfferDto offer = offerService.getViewOfferById(id);
        modelAndView.addObject("offer", offer);
        UserEntity userEntity = userService.findById(offer.getSellerId());

        String userName = String.format("%s %s", userEntity.getFirstName(), userEntity.getLastName());
        modelAndView.addObject("userName", userName);

        return view("details.html", modelAndView);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable(name = "id") String id,
                                  ModelAndView modelAndView) {

        offerService.deleteOffer(id);
        return redirect("/offers/all", modelAndView);
    }


    @PostMapping("/update/{offerId}/seller/{sellerId}")
    public ModelAndView update(@PathVariable(name = "offerId") String offerId,
                               @PathVariable(name = "sellerId") String sellerId,
                               @Valid @ModelAttribute(name = "offerView") ViewOfferDto viewOfferDto,
                               BindingResult result,
                               ModelAndView modelAndView) {

        if (result.hasErrors()) {
            modelAndView.addObject("offerView", viewOfferDto);
            modelAndView.addObject("allModels", modelService.getAllModels());
            return view("update.html", modelAndView);
        }

        viewOfferDto.setSellerId(sellerId);
        viewOfferDto.setId(offerId);
        offerService.updateOffer(viewOfferDto);

        return redirect(String.format("/offers/details/%s", viewOfferDto.getId()), modelAndView);
    }
}