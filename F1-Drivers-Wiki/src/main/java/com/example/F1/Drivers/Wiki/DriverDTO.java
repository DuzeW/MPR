package com.example.F1.Drivers.Wiki;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class DriverDTO {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    String lastName;
    LocalDate dateOfBirth;
    String team;
    String racingSeries;

    public DriverDTO(String name, String lastName, LocalDate dateOfBirth, String team) {
        this.dateOfBirth=dateOfBirth;
        this.name=name;
        this.lastName=lastName;
        this.team=team;
    }

    protected DriverDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    public String racingSeries() {
        return racingSeries;
    }

    public void racingSeries(String team) {
        this.racingSeries = team;
    }
}
