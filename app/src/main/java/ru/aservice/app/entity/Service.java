package ru.aservice.app.entity;


import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "service")
@Setter
public class Service extends BaseEntity {

    private String masterFullName;

    @Override
    public Long getId() {
        return super.getId();
    }

    public String getMasterFullName() {
        return masterFullName;
    }
}
