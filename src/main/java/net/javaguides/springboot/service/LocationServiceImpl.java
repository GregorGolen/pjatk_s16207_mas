package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Location;
import net.javaguides.springboot.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public void saveLocation(Location location) {
        this.locationRepository.save(location);
    }

    @Override
    public Location getLocationById(long id) {
        Optional<Location> optional = locationRepository.findById(id);
        Location location = null;
        if (optional.isPresent()) {
            location = optional.get();
        } else {
            throw new RuntimeException("Location not found for id :: " + id);
        }
        return location;
    }

    @Override
    public void deleteLocationById(long id) {
        this.locationRepository.deleteById(id);
    }

}


