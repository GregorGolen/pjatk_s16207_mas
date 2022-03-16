package net.javaguides.springboot.model;


import net.javaguides.springboot.Utils.EquipmentTypeEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "equipments")
public class Equipment {

    public long getId() {
        return equipment_id;
    }

    public void setId(long id) {
        this.equipment_id = id;
    }

    public EquipmentTypeEnum getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentTypeEnum equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long equipment_id;

    @Column(name = "equipmeny_type")
    @Enumerated(EnumType.STRING)
    private EquipmentTypeEnum equipmentType;

    @Column(name = "brand")
    private String brand;

    public long getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(long equipment_id) {
        this.equipment_id = equipment_id;
    }

    public Set<LeaseUsed> getLeases() {
        return leases;
    }

    public void setLeases(Set<LeaseUsed> leases) {
        this.leases = leases;
    }

    @Column(name = "price")
    private Double price;

    @OneToMany
    @JoinColumn(name="equipment_id")
    private Set<LeaseUsed> leases;

    public void rent(){
        System.out.println("Equipment has been rented");
    }

    public void returnEqipment(){
        System.out.println("Equipment has been returned");
    }
}
