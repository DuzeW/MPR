package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


}
