package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Offer;

import java.util.List;


public interface OfferService {
    List<Offer> getAllOffers();
    void saveOffer(Offer offer);
    void saveOfferWithCarnets(Offer offer);
    Offer getOfferById(long id);
    void deleteOfferById(long id);
}
