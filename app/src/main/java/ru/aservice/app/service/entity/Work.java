package ru.aservice.app.service.entity;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "works")
@Setter
public class Work extends BaseEntity{

    public Service service;

    @Override
    public Long getId() {
        return super.getId();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Service getService() {
        return service;
    }
}
