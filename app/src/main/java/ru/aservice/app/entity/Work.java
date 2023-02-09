package ru.aservice.app.entity;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "works")
@Setter
public class Work extends BaseEntity {

    public Service service;
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
