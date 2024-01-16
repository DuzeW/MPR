package com.example.demo;
import ch.qos.logback.core.model.Model;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MyRestService {
    public static final String API_URL = "http://localhost:8080";
    private RestTemplate restTemplate;

    public MyRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    };
    RestClient restClient;

    public MyRestService() {
        restClient = RestClient.create();
    }
    

    @GetMapping("/getAllDrivers")
    public List<DriverDTO> getAllDrivers() {
        List<DriverDTO> allDrivers = restClient
                .get()
                .uri(API_URL + "/getAllDrivers")
                .retrieve()
                .body(new ParameterizedTypeReference<List<DriverDTO>>() {
                });
        return allDrivers;
    }
    @GetMapping("/getDriverByName")
    public DriverDTO getDriverByName(@RequestParam String name) {
        DriverDTO driverByName = restClient
                .get()
                .uri(URI.create(
                        UriComponentsBuilder.fromHttpUrl(API_URL + "/getDriverByName")
                                .queryParam("name", name)
                                .toUriString()))
                .retrieve()
                .body(new ParameterizedTypeReference<DriverDTO>() {
                });
        return driverByName;
    }
    @GetMapping("/getDriverById")
    public DriverDTO getDriverById(@RequestParam Long id) {
        DriverDTO driverByid = restClient
                .get()
                .uri(URI.create(
                        UriComponentsBuilder.fromHttpUrl(API_URL + "/getDriverById")
                                .queryParam("id", id)
                                .toUriString()))
                .retrieve()
                .body(new ParameterizedTypeReference<DriverDTO>() {
                });
        return driverByid;
    }
    @PostMapping("/addDriver")
    public DriverDTO addDriver(@RequestParam String name, @RequestParam String dateOfBirth, @RequestParam String team, @RequestParam String racingSeries) {
        String targetUrl = UriComponentsBuilder.fromHttpUrl(API_URL + "/addDriver")
                .queryParam("name", name)
                .queryParam("dateOfBirth", dateOfBirth)
                .queryParam("team", team)
                .queryParam("racingSeries", racingSeries)
                .build()
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(targetUrl, null, DriverDTO.class);
    }
    @PutMapping("/updateDriver")
    public void updateDriver(@RequestParam Long id, @RequestParam String name, @RequestParam String dateOfBirth, @RequestParam String team, @RequestParam String racingSeries) {
        //^ RequestBody
        String targetUrl = UriComponentsBuilder.fromHttpUrl(API_URL + "/updateDriver")
                .queryParam("id", id)
                .queryParam("name", name)
                .queryParam("dateOfBirth", dateOfBirth)
                .queryParam("team", team)
                .queryParam("racingSeries", racingSeries)
                .build()
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(targetUrl, null, DriverDTO.class);
    }
    @DeleteMapping("/deleteDriver")
    public void deleteDriver(@RequestParam Long id) {
        String targetUrl = UriComponentsBuilder.fromHttpUrl(API_URL + "/deleteDriver")
                .queryParam("id", id)
                .build()
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(targetUrl);
    }
}
