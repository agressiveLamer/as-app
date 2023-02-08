package ru.aservice.app.entity;

import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Setter
public abstract class BaseEntity implements Serializable {

    private Long id;
    private Date created;
    private Date updated;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    @CreationTimestamp
    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    @UpdateTimestamp
    @Column(name = "updated")
    public Date getUpdated() {
        return updated;
    }

}
