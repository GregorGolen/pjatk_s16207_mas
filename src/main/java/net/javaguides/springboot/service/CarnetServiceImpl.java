package net.javaguides.springboot.service;

import net.javaguides.springboot.helpers.CompositionHelper;
import net.javaguides.springboot.model.Carnet;
import net.javaguides.springboot.repository.CarnetRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CarnetServiceImpl implements CarnetService{

    @Autowired
    CarnetRepository carnetRepository;

    @Override
    public void saveCarnet(Carnet carnet) {
        if((carnet.getAssignedOfferId() != null) && !CompositionHelper.existAssignedCarnet(carnet))
        this.carnetRepository.save(carnet);
    }

    public void deleteCarnetById(long id) {
        this.carnetRepository.deleteById(id);

    }

}
