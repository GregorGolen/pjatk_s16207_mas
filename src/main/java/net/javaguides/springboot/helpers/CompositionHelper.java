package net.javaguides.springboot.helpers;


import net.javaguides.springboot.model.Carnet;
import net.javaguides.springboot.model.Offer;
import net.javaguides.springboot.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompositionHelper {

    @Autowired
    private static OfferService offerService;

    public static Set<Carnet> keepRecordOfAllCarnetsAssignedToOffers(){
        List<Offer> allOffers = offerService.getAllOffers();
        Set<Carnet> allAssignedCarnets = new HashSet<>();
        for(Offer o : allOffers){
            allAssignedCarnets.addAll(o.getCarnets());
        }
                return allAssignedCarnets;
    }

    public static Set<Carnet> allAssignedCarnets = keepRecordOfAllCarnetsAssignedToOffers();

    public static boolean existAssignedCarnet(Carnet newCarnet){
        return allAssignedCarnets.contains(newCarnet);
    }


}
