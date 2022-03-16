package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {

    public Location(){}

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long location_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany
    @JoinColumn(name="location_id")
    private Set<Training> trainings;


    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    @ManyToMany
    @JoinTable(
            name = "Location_Activity",
            joinColumns = { @JoinColumn(name = "location_id") },
            inverseJoinColumns = { @JoinColumn(name = "activity_id") }
    )
    Set<Activity> activities = new HashSet<>();

    public long getId() {
        return location_id;
    }

    public void setId(long id) {
        this.location_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }
}
