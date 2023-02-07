package ru.aservice.app.service.entity;

import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Table(schema = "public", name = "user")
public class User extends BaseEntity {

    private String login;
    private String password;
    private String name;
    private String lastname;
    private String phoneNumber;
    private String email;
    private List<Car> cars;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "last_name")
    public String getLastname() {
        return lastname;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @ManyToMany(mappedBy = "ownerList")
    public List<Car> getCars() {
        return cars;
    }
}
