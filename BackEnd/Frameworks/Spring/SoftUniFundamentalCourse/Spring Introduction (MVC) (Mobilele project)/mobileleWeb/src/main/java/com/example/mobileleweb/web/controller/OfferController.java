package com.example.mobileleweb.web.controller;

import com.example.mobileleweb.domain.entity.User;
import com.example.mobileleweb.domain.viewDtos.LoggedUser;
import com.example.mobileleweb.domain.viewDtos.ViewOffer;
import com.example.mobileleweb.service.Model.ModelService;
import com.example.mobileleweb.service.Offer.OfferService;
import com.example.mobileleweb.service.User.UserService;
import com.example.mobileleweb.web.constants.BaseModelAndView;
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
        modelAndView.addObject("offerView", new ViewOffer());
        return view("offer-add.html", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addOffer(@Valid @ModelAttribute(name = "offerView") ViewOffer offerView,
                                 BindingResult result,
                                 ModelAndView modelAndView,
                                 HttpSession session) {

        if (result.hasErrors()) {
            modelAndView.addObject("allModels", modelService.getAllModels());
            return view("offer-add.html", modelAndView);
        }
        LoggedUser user = (LoggedUser) session.getAttribute("loggedUser");
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

        ViewOffer offer = offerService.getViewOfferById(id);
        modelAndView.addObject("offer", offer);
        User user = userService.findById(offer.getSellerId());

        String userName = String.format("%s %s", user.getFirstName(), user.getLastName());
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
                               @Valid @ModelAttribute(name = "offerView") ViewOffer viewOffer,
                               BindingResult result,
                               ModelAndView modelAndView) {

        if (result.hasErrors()) {
            modelAndView.addObject("offerView", viewOffer);
            modelAndView.addObject("allModels", modelService.getAllModels());
            return view("update.html", modelAndView);
        }

        viewOffer.setSellerId(sellerId);
        viewOffer.setId(offerId);
        offerService.updateOffer(viewOffer);

        return redirect(String.format("/offers/details/%s", viewOffer.getId()), modelAndView);
    }
}