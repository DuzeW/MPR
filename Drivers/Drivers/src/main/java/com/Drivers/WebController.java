package com.Drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WebController {

    private MyRestService myRestService;
    @Autowired
    public WebController(MyRestService myRestService) {
        this.myRestService = myRestService;
    }
    @GetMapping("/getAllDrivers")
    public List<DriverDTO> getAllDrivers() {
        return this.myRestService.getAllDrivers();
    }
    @GetMapping("/getDriverByName")
    public DriverDTO getDriverByName(@RequestParam String name) {
        return this.myRestService.getDriverByName(name);
    }
    @GetMapping("/getDriverById")
    public DriverDTO getDriverById(@RequestParam Long id) {
        return this.myRestService.getDriverById(id);
    }
    @PostMapping( "/addDriver")
    public DriverDTO addDriver(@RequestParam String name,@RequestParam String dateOfBirth,@RequestParam String team,@RequestParam String racingSeries) {
        DriverDTO driverDTO = new DriverDTO(name, LocalDate.parse(dateOfBirth), team, racingSeries);
        return this.myRestService.addDriver(driverDTO);
    }
    @PutMapping("/updateDriver")
    public DriverDTO updateDriver(@RequestParam Long id, @RequestParam String name, @RequestParam String dateOfBirth, @RequestParam String team, @RequestParam String racingSeries) {
        this.myRestService.updateDriver(id, name,  LocalDate.parse(dateOfBirth), team, racingSeries);
        return this.myRestService.getDriverById(id);
    }
    @DeleteMapping("/deleteDriver")
    public void deleteDriver(@RequestParam Long id) {
        this.myRestService.deleteDriver(id);
    }
    @GetMapping("/getDriverCar")
    public CarDTO getDriverCar(@RequestParam Long id) {
        return this.myRestService.getDriverCar(id);
    }
    @GetMapping("/getCar")
    public CarDTO getCar(@RequestParam Long id){
        return this.myRestService.getCar(id);
    }
    @GetMapping("/getDriverAchievements")
    public List<String> getDriverAchievements(@RequestParam Long id) {
        return this.myRestService.getDriverAchievements(id);
    }


}
