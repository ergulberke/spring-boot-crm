package com.turkcell.order_service.controllers;

import com.turkcell.order_service.client.ProductClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final ProductClient productClient;

    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }


    @GetMapping
    public String get(){
        String response = productClient.get();
        System.out.println(response);
        return "Order Service.";
    }

}
