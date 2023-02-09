package ru.aservice.app.entity;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "spares")
@Setter
public class Spare extends BaseEntity {

    private Service service;
    private String describe;
    private Double cost;


    @Override
    public Long getId() {
        return super.getId();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Service getService() {
        return service;
    }

    public String getDescribe() {
        return describe;
    }

    public Double getCost() {
        return cost;
    }
}
