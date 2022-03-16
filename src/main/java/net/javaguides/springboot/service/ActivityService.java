package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> getAllActivities();
    /*List<Activity> getAllActivitiesInLocation(long id);*/
    void saveActivity(Activity activity);
    Activity getActivityById(long id);
    void deleteActivityById(long id);

}
