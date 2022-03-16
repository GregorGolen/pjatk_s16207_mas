package net.javaguides.springboot.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long training_id;

    @Column(name="date")
    private LocalDate date;

    public long getId() {
        return training_id;
    }

    public void setId(long id) {
        this.training_id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
