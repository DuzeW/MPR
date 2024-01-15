package com.Drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WebC {

    private MyRestService myRestService;
    @Autowired
    public WebC(MyRestService myRestService) {
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
    @GetMapping("/addDriver")
    public DriverDTO addDriver(@RequestBody DriverDTO driverDTO) {
        return this.myRestService.addDriver(driverDTO);
    }
    @DeleteMapping("/deleteDriver")
    public void deleteDriver(@RequestParam Long id) {
        this.myRestService.deleteDriver(id);
    }
    @PutMapping("/updateDriver")
    public void updateDriver(@RequestParam Long id, @RequestParam String name, @RequestParam LocalDate dateOfBirth, @RequestParam String team, @RequestParam String racingSeries) {
        this.myRestService.updateDriver(id, name, dateOfBirth, team, racingSeries);
    }
}
