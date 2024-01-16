package com.Client;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class MyRestService {
    public static final String API_URL = "http://localhost:8080";
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
                .body(new ParameterizedTypeReference<List<DriverDTO>>() { });
        return allDrivers;
    }
}
