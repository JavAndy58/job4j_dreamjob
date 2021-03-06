package ru.job4j.dream.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Candidate {
    private int id;
    private String name;
    private String desc;
    private LocalDate created;
    private byte[] photo;

    public Candidate(int id, String name, String desc, LocalDate created, byte[] photo) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.photo = photo;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id && Objects.equals(name, candidate.name) && Objects.equals(desc, candidate.desc) && Objects.equals(created, candidate.created) && Arrays.equals(photo, candidate.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, desc, created);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}
