package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Carnet;


public interface CarnetService {

    void saveCarnet(Carnet carnet);
    void deleteCarnetById(long id);

    }

