package com.Drivers;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "driver")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class DriverDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String team;
    private String racingSeries;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarDTO carDTO;

    public CarDTO getCarDTO() {
        return carDTO;
    }

    public void setCarDTO(CarDTO carDTO) {
        this.carDTO = carDTO;
    }

    @OneToMany(mappedBy = "driver")
    private List<AchievementDTO> achievements;

    public List<AchievementDTO> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<AchievementDTO> achievements) {
        this.achievements = achievements;
    }





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


    private Long cId;
    public Long getCId() {
        return cId;
    }
    public void setCarId(Long cId) {
        this.cId = cId;
    }

    public DriverDTO(String name, LocalDate dateOfBirth, String team, String racingSeries, Long cId) {
        this.dateOfBirth=dateOfBirth;
        this.name=name;
        this.team=team;
        this.racingSeries=racingSeries;
        this.cId = cId;
    }
}
