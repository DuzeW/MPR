package com.Drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MyRestService {
    @Autowired
    DriverRepository driverRepository;

    CarRepository carRepository;
    AchievementRepository achievementRepository;


    public MyRestService(DriverRepository driverRepository, CarRepository carRepository,AchievementRepository achievementRepository) {
        this.driverRepository = driverRepository;
        this.carRepository=carRepository;
        this.achievementRepository=achievementRepository;
        this.carRepository.save(new CarDTO("RB18",740L,798L));
        DriverDTO driver = new DriverDTO("Max Verstappen", LocalDate.parse("1997-09-30"), "Red Bull Racing", "Formula 1",1L);
        this.driverRepository.save(driver);
        AchievementDTO achievement = new AchievementDTO(1L,"World Champion 2023");
        AchievementDTO achievement2 = new AchievementDTO(1L,"World Champion 2022");
        achievement.setDriver(driver);
        achievement2.setDriver(driver);
        this.achievementRepository.save(achievement);
        this.achievementRepository.save(achievement2);


        DriverDTO driver2 = new DriverDTO("Sergio Perez", LocalDate.parse("1990-01-26"), "Red Bull Racing", "Formula 1",1L);
        this.driverRepository.save(driver2);
        AchievementDTO achievement3 = new AchievementDTO(2L,"Second Championship 2023");
        achievement3.setDriver(driver2);
        this.achievementRepository.save(achievement3);

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

    public CarDTO getCar (Long id){
        return carRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Car not found with id : " + id));
    }

    public CarDTO getDriverCar (Long id){
        Optional<DriverDTO> optionalDriver = this.driverRepository.findById(id);
        if (optionalDriver.isPresent()) {
            DriverDTO driver = optionalDriver.get();
            Long cid = driver.getCId();
            return carRepository.findById(cid).orElseThrow(() -> new NoSuchElementException("Car not found with id : " + cid));
        } else {
            throw new NoSuchElementException("Driver not found with id : " + id);
        }
    }
    public List<String> getDriverAchievements(Long id) {
        List<AchievementDTO> achievements = (List<AchievementDTO>) achievementRepository.findAll();

        List<String> filterAchievements = achievements.stream()
                .filter(achievement -> achievement.getDriverId().equals(id))
                .map(AchievementDTO::getName)
                .collect(Collectors.toList());
        return filterAchievements;
    }

}
