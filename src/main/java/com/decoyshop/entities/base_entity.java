package com.decoyshop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class base_entity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OBJECT_ID",nullable = false)
    private int id;

    public <T extends base_entity> T setId(int id) {
        this.id = id;
        return (T) this;
    }
}
