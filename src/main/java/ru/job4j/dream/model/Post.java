package ru.job4j.dream.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Post implements Serializable {
    private int id;
    private String name;
    private String description;
    private LocalDate created;
    private City city;

    public Post(int id, String name, String description, LocalDate created, City city) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


}
