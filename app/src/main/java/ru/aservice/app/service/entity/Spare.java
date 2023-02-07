package ru.aservice.app.service.entity;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "spares")
@Setter
public class Spare extends BaseEntity{

    private Service service;

    @Override
    public Long getId() {
        return super.getId();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Service getService() {
        return service;
    }
}
