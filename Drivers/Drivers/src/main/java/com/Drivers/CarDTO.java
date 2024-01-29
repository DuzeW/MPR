package com.Drivers;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class CarDTO {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "car")
    private DriverDTO driverDTO;

    String name;
    Long hp;
    Long wight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DriverDTO getDriverDTO() {
        return driverDTO;
    }

    public void setDriverDTO(DriverDTO driverDTO) {
        this.driverDTO = driverDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHp() {
        return hp;
    }

    public void setHp(Long hp) {
        this.hp = hp;
    }

    public Long getWight() {
        return wight;
    }

    public void setWight(Long wight) {
        this.wight = wight;
    }



}
