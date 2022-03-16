package net.javaguides.springboot.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leases")
public class LeaseUsed {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long lease_id;

    @Column(name="date_start")
    private LocalDate dateStart;

    @Column(name="date_end")
    private LocalDate dateEnd;

    @Column(name="date_returned")
    private LocalDate dateReturned;

    public long getId() {
        return lease_id;
    }

    public void setId(long id) {
        this.lease_id = id;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }
}

