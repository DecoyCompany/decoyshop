package com.example.myapplication.entities;

public abstract class base_entity
{
    private int id;

    public <T extends base_entity> T setId(int id) {
        this.id = id;
        return (T) this;
    }

    public int getId() {
        return id;
    }
}
