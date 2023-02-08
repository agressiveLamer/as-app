package ru.aservice.app.entity;

import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Table(schema = "public", name = "car")
public class Car extends BaseEntity {

    private String make;
    private String model;
    private int year;
    private String color;
    private String vin;
    private List<User> ownerList;
    private String registrationNumber;
    private int mileage;
    private String notes;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }
    @Column(name = "vin")
    public String getVin() {
        return vin;
    }



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "car_user",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")

    )
    public List<User> getOwnerList() {
        return ownerList;
    }

    @Column(name = "registration_number")
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }
}
