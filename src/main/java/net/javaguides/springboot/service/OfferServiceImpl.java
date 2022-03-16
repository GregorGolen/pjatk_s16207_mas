package net.javaguides.springboot.service;

import net.javaguides.springboot.helpers.CompositionHelper;
import net.javaguides.springboot.model.Carnet;
import net.javaguides.springboot.model.Offer;
import net.javaguides.springboot.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }


    @Override
    public void saveOffer(Offer offer) {
            this.offerRepository.save(offer);
    }

    @Override
    public void saveOfferWithCarnets(Offer offer) {
        Set<Carnet> myCarnets = offer.getCarnets();
        Set<Carnet> allAssignedCarnets = CompositionHelper.keepRecordOfAllCarnetsAssignedToOffers();
        if(!myCarnets.isEmpty() && !Collections.disjoint(myCarnets, allAssignedCarnets)){
            System.out.println("The carnets being assigned are already assigned to other offer");
        } else {
            this.offerRepository.save(offer);
        }
    }

    @Override
    public Offer getOfferById(long id) {
        Optional<Offer> optional = offerRepository.findById(id);
        Offer offer = null;
        if (optional.isPresent()) {
            offer = optional.get();
        } else {
            throw new RuntimeException("Offer not found for id :: " + id);
        }
        return offer;
    }

/*    @Override
    public Offer getOfferById(long id) {
        return offerRepository.findById(id);
    }*/

    @Override
    public void deleteOfferById(long id) {
        this.offerRepository.deleteById(id);

    }

}

