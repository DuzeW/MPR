package com.Drivers;

import jakarta.persistence.*;

@Entity
@Table(name = "achievement")
public class AchievementDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private DriverDTO driver;


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

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }
    public AchievementDTO (String name){
        this.name = name;
    }
    public AchievementDTO (Long id,String name){
        this.name = name;
        this.dId=id;
    }
    public AchievementDTO(){}










    public Long getDriverId() {
        return dId;
    }

    public void setDriverId(Long dId) {
        dId = dId;
    }

    public Long dId;

}
