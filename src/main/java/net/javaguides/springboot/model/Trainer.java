package net.javaguides.springboot.model;


import net.javaguides.springboot.Utils.IProfessionalAthlete;
import net.javaguides.springboot.Utils.SpecializationEnum;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trainers")
public class Trainer extends Person implements IProfessionalAthlete {

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    @Nullable
    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(@Nullable String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public List<SpecializationEnum> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<SpecializationEnum> specializations) {
        this.specializations = specializations;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "nip")
    private String nip;

    @Column(name = "agreement_no")
    private String agreementNo;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "insurance_no")
    private String insuranceNo;

    @Nullable
    @Column(name = "license_no")
    private String licenseNo;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<SpecializationEnum> specializations = new ArrayList<SpecializationEnum>();

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    @ManyToMany
    @JoinTable(
            name = "Trainer_Activity",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "activity_id") }
    )
    Set<Activity> activities = new HashSet<>();

    @Override
    public void enlistToTournament() {
        System.out.println("Trainer enlisted");
    }

    @Override
    public void payStartFee() {
        System.out.println("Trainer's participation paid");
    }

    @Override
    public void provideHealthStatement() {
        System.out.println("Trainer's statement provided");
    }

}

