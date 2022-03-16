package net.javaguides.springboot.model;

import net.javaguides.springboot.Utils.IProfessionalAthlete;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member extends Person implements IProfessionalAthlete {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Nullable
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(@Nullable String discount) {
        this.discount = discount;
    }

    @Nullable
    @Column(name = "discount")
    private String discount;

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

 /*   protected Date dateToConvert = this.getBirthDate();

    LocalDate convertedDate = dateToConvert != null ? convertToLocalDateViaInstant(dateToConvert) : LocalDate.now();*/

/*
    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - convertedDate.getYear();
        return age;
    }
*/

    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - getBirthDate().getYear();
        return age;
    }



    public Set<Carnet> getCarnets() {
        return carnets;
    }

    public void setCarnets(Set<Carnet> carnets) {
        this.carnets = carnets;
    }

    @OneToMany
    @JoinColumn(name="id")
    private Set<Carnet> carnets;

    public Set<LeaseUsed> getLeases() {
        return leases;
    }

    public void setLeases(Set<LeaseUsed> leases) {
        this.leases = leases;
    }

    @OneToMany
    @JoinColumn(name="id")
    private Set<LeaseUsed> leases;

    @Override
    public void enlistToTournament() {
        System.out.println("Member enlisted");
    }

    @Override
    public void payStartFee() {
        System.out.println("Member's participation paid");
    }

    @Override
    public void provideHealthStatement() {
        System.out.println("Member's statement provided");
    }
}
