package com.example.F1.Drivers.Wiki;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class DriverDTO {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    String lastName;
    Date dateOfBirth;

}
