package net.javaguides.springboot.model;

import net.javaguides.springboot.Utils.LevelType;
import net.javaguides.springboot.Utils.SpecializationEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long activity_id;

    @Column(name = "max_participants")
    private int maxParticipants;

    @Column(name = "min_participants")
    private int minParticipants;

    @Column(name = "specialization")
    @Enumerated(EnumType.STRING)
    private SpecializationEnum specialization;

    @Column(name = "types")
    @Enumerated(EnumType.STRING)
    private LevelType type;

    public long getId() {
        return activity_id;
    }

    public void setId(long id) {
        this.activity_id = id;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(int minParticipants) {
        this.minParticipants = minParticipants;
    }

    public SpecializationEnum getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecializationEnum specialization) {
        this.specialization = specialization;
    }

    public LevelType getType() {
        return type;
    }

    public void setType(LevelType type) {
        this.type = type;
    }

    public long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(long activity_id) {
        this.activity_id = activity_id;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    @ManyToMany(mappedBy = "activities")
    private Set<Location> locations = new HashSet<>();

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    @ManyToMany
    @JoinTable(
            name = "Activity_Offers",
            joinColumns = { @JoinColumn(name = "activity_id") },
            inverseJoinColumns = { @JoinColumn(name = "offer_id") }
    )
    Set<Offer> offers = new HashSet<>();

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }

    @ManyToMany(mappedBy = "activities")
    private Set<Trainer> trainers = new HashSet<>();

    @OneToMany
    @JoinColumn(name="activity_id")
    private Set<Training> trainings;
}
