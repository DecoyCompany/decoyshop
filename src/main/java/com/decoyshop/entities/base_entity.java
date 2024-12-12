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

}
