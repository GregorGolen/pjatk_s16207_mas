package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long offer_id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="start_date")
    private String startDate;

    @Column(name="end_date")
    private String endDate;

    @Column(name="price")
    private Double price;

    public long getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(long offer_id) {
        this.offer_id = offer_id;
    }

    public Set<Carnet> getCarnets() {
        return carnets;
    }

    public void setCarnets(Set<Carnet> carnets) {
        this.carnets = carnets;
    }

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name="offer_id")
    private Set<Carnet> carnets;

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    @ManyToMany(mappedBy = "offers")
    private Set<Activity> activities = new HashSet<>();


    public long getId() {
        return offer_id;
    }

    public void setId(long id) {
        this.offer_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
