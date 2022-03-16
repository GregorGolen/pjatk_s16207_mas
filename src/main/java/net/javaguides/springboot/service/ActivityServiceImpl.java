package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Activity;
import net.javaguides.springboot.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void saveActivity(Activity activity) {
        this.activityRepository.save(activity);
    }

    @Override
    public Activity getActivityById(long id) {
        Optional<Activity> optional = activityRepository.findById(id);
        Activity activity = null;
        if (optional.isPresent()) {
            activity = optional.get();
        } else {
            throw new RuntimeException("Activity not found for id :: " + id);
        }
        return activity;
    }

    @Override
    public void deleteActivityById(long id) {
        this.activityRepository.deleteById(id);
    }

    /*@Override
    public List<Activity> getAllActivitiesInLocation(long id) { return activityRepository.findAllActivitesInLocation(id);};*/

}
