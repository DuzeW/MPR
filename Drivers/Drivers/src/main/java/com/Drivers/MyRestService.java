package com.Drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class MyRestService {
    @Autowired
    DriverRepository driverRepository;

    public MyRestService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
        this.driverRepository.save(new DriverDTO("Max Verstappen", LocalDate.parse("1997-09-30"), "Red Bull Racing", "Formula 1"));
        this.driverRepository.save(new DriverDTO("Sergio Perez", LocalDate.parse("1990-01-26"), "Red Bull Racing", "Formula 1"));
        this.driverRepository.save(new DriverDTO("Lewis Hamilton", LocalDate.parse("1985-01-07"), "Mercedes", "Formula 1"));
        this.driverRepository.save(new DriverDTO("George Russell", LocalDate.parse("1998-02-15"), "Mercedes", "Formula 1"));
        this.driverRepository.save(new DriverDTO("Charles Leclerc", LocalDate.parse("1997-10-16"), "Ferrari", "Formula 1"));
        this.driverRepository.save(new DriverDTO("Carlos Sainz", LocalDate.parse("1994-09-01"), "Ferrari", "Formula 1"));
        this.driverRepository.save(new DriverDTO("Lando Norris", LocalDate.parse("1999-11-13"), "McLaren", "Formula 1"));
        this.driverRepository.save(new DriverDTO("Yuki Tsunoda", LocalDate.parse("2000-05-11"), "AlphaTauri", "Formula 1"));
        this.driverRepository.save(new DriverDTO("Kalle Rovanperä", LocalDate.parse("2000-10-01"), "TOYOTA GAZOO RACING WORLD RALLY TEAM", "WRC"));
        this.driverRepository.save(new DriverDTO("Elfyn Evans", LocalDate.parse("1988-12-28"), "TOYOTA GAZOO RACING WORLD RALLY TEAM", "WRC"));
        this.driverRepository.save(new DriverDTO("Thierry Neuville", LocalDate.parse("1988-06-16"), "HYUNDAI SHELL MOBIS WORLD RALLY TEAM", "WRC"));
    }

    public List<DriverDTO> getAllDrivers() {
        return (List<DriverDTO>) driverRepository.findAll();
    }
    public DriverDTO getDriverByName(String name) {
        DriverDTO getDriver = this.driverRepository.findByName(name);
        if (getDriver == null) {
            throw new NoSuchElementException("Driver not found: " + name);
        } else {
            return this.driverRepository.findByName(name);
        }
    }
    public DriverDTO getDriverById(Long id) {
        Optional<DriverDTO> optionalDriver = this.driverRepository.findById(id);
        if (optionalDriver.isPresent()) {
            DriverDTO driver = optionalDriver.get();
            return driver;
        } else {
            throw new NoSuchElementException("Driver not found with id : " + id);
        }
    }

    public DriverDTO addDriver(DriverDTO driverDTO) {
            return this.driverRepository.save(driverDTO);
    }
    public void updateDriver(Long id, String name, LocalDate dateOfBirth, String team, String racingSeries) {
        Optional<DriverDTO> driver = driverRepository.findById(id);
        if (driver.isPresent()) {
            DriverDTO existingDriver = driverRepository.findById(id).orElseThrow();
            existingDriver.setName(name);
            existingDriver.setDateOfBirth(dateOfBirth);
            existingDriver.setTeam(team);
            existingDriver.setRacingSeries(racingSeries);
            driverRepository.save(existingDriver);
        } else {
            throw new NoSuchElementException("Driver not found with id : " + id);
        }
    }
    public void deleteDriver(Long id) {
        driverRepository.delete(getDriverById(id));
    }
}
