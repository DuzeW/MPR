package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    private MyRestService myRestService;
    @Autowired
    public WebController(MyRestService carService) {
        this.myRestService = carService;

    }
    @GetMapping("/drivers")
    public String all(Model model)
    {
        model.addAttribute("drivers",myRestService.getAllDrivers());
        return "drivers";
    }
    @GetMapping("/driverByName")
    public String getDriverByName(@RequestParam String name, Model model) {
        model.addAttribute("NamedDrivers",myRestService.getDriverByName(name));
        return "driverByName";
    }
    @GetMapping("/driverById")
    public String getDriverById(@RequestParam Long id, Model model) {
        model.addAttribute("IdDriver", myRestService.getDriverById(id));
        return "driverById";
    }
    @PutMapping("/addDriver")
    public String addDriver(@RequestParam String name, @RequestParam String dateOfBirth, @RequestParam String team, @RequestParam String racingSeries, Model model) {
        DriverDTO driver = myRestService.addDriver(name, dateOfBirth, team, racingSeries);
        model.addAttribute("AddedDriver", driver);
        return "addDriver";
    }
    @PostMapping("/deleteDriver")
    public String deleteDriver(@RequestParam Long id, Model model) {
        myRestService.deleteDriver(id);
        model.addAttribute("DeletedDriverId", id);
        return "deleteDriver";
    }
    @PostMapping("/updateDriver")
    public String updateDriver(@RequestParam Long id, @RequestParam String name, @RequestParam String dateOfBirth, @RequestParam String team, @RequestParam String racingSeries, Model model) {
        myRestService.updateDriver(id, name, dateOfBirth, team, racingSeries);
        model.addAttribute("UpdatedDriverId", id);
        return "updateDriver";
    }


}
