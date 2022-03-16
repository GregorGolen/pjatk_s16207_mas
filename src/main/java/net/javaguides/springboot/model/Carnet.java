package net.javaguides.springboot.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "carnets")
public class Carnet {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long carnet_id;

    @Column(name = "carnet")
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "payment_date")
    private LocalDate payment_date;

    @Column(name="price")
    private Double price;


    public void printCarnet(){
        System.out.println("Carnet is being printed");
    }

    public long getId() {
        return carnet_id;
    }

    public void setId(long id) {
        this.carnet_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getCarnet_id() {
        return carnet_id;
    }

    public void setCarnet_id(long carnet_id) {
        this.carnet_id = carnet_id;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    @OneToMany
    @JoinColumn(name="carnet_id")
    private Set<Training> trainings;



    // Wartość przypisana np. w systemie sprzedaży
    // , w momencie sprzedaży karnetu klientowi

    @Transient
    private Long assignedOfferId;

    public Long getAssignedOfferId() {
        return assignedOfferId;
    }


}

