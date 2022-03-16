package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Offer;
import net.javaguides.springboot.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class OfferController {

    @Autowired
    private OfferService offerService;



    @GetMapping("/offers")
    public String offers(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("offers", offers);
        return "offers";
    }

    @PostMapping("/saveOffer")
    public String saveOffer(@ModelAttribute("offer") Offer offer) {
                offerService.saveOffer(offer);
        return "redirect:offers";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        Offer offer = offerService.getOfferById(id);

        model.addAttribute("offer", offer);
        return "update_offer";
    }


}

