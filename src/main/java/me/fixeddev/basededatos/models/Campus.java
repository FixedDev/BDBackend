package me.fixeddev.basededatos.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Campuses")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campusesId")
    private Long campusesId;

    @Column(nullable = false, name = "Name")
    private String name;

    public Campus(Long campusesId, String name) {
        this.campusesId = campusesId;
        this.name = name;
    }

    public Campus() {

    }

    public void setCampusesId(Long campusesId) {
        this.campusesId = campusesId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCampusesId() {
        return campusesId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "campusesId=" + campusesId +
                ", name='" + name + '\'' +
                '}';
    }
}