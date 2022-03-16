package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();
    void saveLocation(Location location);
    Location getLocationById(long id);
    void deleteLocationById(long id);

}

