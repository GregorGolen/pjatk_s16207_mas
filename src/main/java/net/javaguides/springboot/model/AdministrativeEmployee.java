package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "administrativeemployees")
public class AdministrativeEmployee extends Person{

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getIsPolishDealRelief() {
        return isPolishDealRelief;
    }

    public void setPolishDealRelief(String polishDealRelief) {
        isPolishDealRelief = polishDealRelief;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "is_relief")
    private String isPolishDealRelief;

    @Column(name = "phone_no")
    private String phoneNo;

}
