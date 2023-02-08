package ru.aservice.app.entity;


import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "service")
@Setter
public class Service extends BaseEntity {

    @Override
    public Long getId() {
        return super.getId();
    }

}
