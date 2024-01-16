package com.example.demo;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;


public class DriverDTO {

    private Long id;
    String name;
    LocalDate dateOfBirth;
    String team;
    String racingSeries;

    public DriverDTO(String name, LocalDate dateOfBirth, String team, String racingSeries) {
        this.dateOfBirth=dateOfBirth;
        this.name=name;
        this.team=team;
        this.racingSeries=racingSeries;
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
    public String getRacingSeries() {
        return racingSeries;
    }

    public void setRacingSeries(String team) {
        this.racingSeries = team;
    }
}
