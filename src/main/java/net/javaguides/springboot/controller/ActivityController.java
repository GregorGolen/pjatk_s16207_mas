package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Activity;
import net.javaguides.springboot.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    @GetMapping("/activities")
    public String activities(Model model) {
        List<Activity> activities = activityService.getAllActivities();
        model.addAttribute("activities", activities);
        return "activities";
    }

    @PostMapping("/saveActivity")
    public String saveActivity(@ModelAttribute("activity") Activity activity) {
        activityService.saveActivity(activity);
        return "redirect:activities";
    }

}
