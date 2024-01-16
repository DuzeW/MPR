package com.Client;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    private MyRestService myRestService;
    @Autowired
    public WebController(MyRestService myRestService) {
        this.myRestService = myRestService;
    }
    @GetMapping("/hello")
    public String witaj(Model model)
    {
        model.addAttribute("Drivers",myRestService.getAllDrivers());
        return "hello";
    }
}
