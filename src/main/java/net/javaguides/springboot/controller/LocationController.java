package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Activity;
import net.javaguides.springboot.model.Location;
import net.javaguides.springboot.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

/*    @Autowired
    private ActivityService activityService;*/


    @GetMapping("/locations")
    public String locations(Model model) {
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations", locations);
        return "locations";
    }

/*    @GetMapping("/activitiesInLocation/{id}")
    public String activitiesInLocation(@PathVariable (value = "id") long id, Model model) {
        List<Activity> activitiesInLocation = activityService.getAllActivitiesInLocation(id);
        model.addAttribute("activitiesInLocation", activitiesInLocation);
        return "location_activities";
    }*/

    @GetMapping("/activitiesInLocation/{id}")
    public String activitiesInLocation(@PathVariable (value = "id") long id, Model model) {
        Location myLocation = locationService.getLocationById(id);
        Set<Activity> activitiesInLocation = myLocation.getActivities();
        model.addAttribute("activitiesInLocation", activitiesInLocation);
        return "location_activities";
    }


    @PostMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") Location location) {
        locationService.saveLocation(location);
        return "redirect:locations";
    }


}
