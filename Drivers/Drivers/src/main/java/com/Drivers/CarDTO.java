package com.Drivers;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class CarDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "carDTO")
    private DriverDTO driverDTO;

    private String name;
    private Long hp;
    private Long weight;

    public CarDTO(String name, Long hp, Long weight){
        this.name = name;
        this.hp = hp;
        this.weight = weight;
    }
    protected CarDTO(){}

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

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long wight) {
        this.weight = weight;
    }





}
