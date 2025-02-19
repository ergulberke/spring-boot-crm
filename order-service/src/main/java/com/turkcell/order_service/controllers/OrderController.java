package com.turkcell.order_service.controllers;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final RestClient restClient;

    public OrderController(RestClient.Builder restClientBuilder){
        restClient = restClientBuilder.baseUrl("http://localhost:8085").build();
    }


    @GetMapping
    public String get(){
        String response = restClient.get().uri("/api/v1/product").retrieve().body(String.class);
        System.out.println("Product Servisten Gelen Cevap: " + response);

        return "Order Service.";
    }

}
