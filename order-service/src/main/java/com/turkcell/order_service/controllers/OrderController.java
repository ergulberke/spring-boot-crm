package com.turkcell.order_service.controllers;

import com.turkcell.order_service.client.ProductClient;
import com.turkcell.order_service.entity.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final ProductClient productClient;
    private final StreamBridge streamBridge;

    public OrderController(ProductClient productClient, StreamBridge streamBridge) {
        this.productClient = productClient;
        this.streamBridge = streamBridge;
    }


    @GetMapping
    public String get(){

        /* Product Servis ile sync iletişim */
        String response = productClient.get();
        System.out.println(response);


        /* Kafka ile async iletişim */
        Order order = new Order();
        order.setId("12345");

        // TODO: kafkadan common class gönder.

        streamBridge.send("orderCreatedFunction-out-0", "Mesaj 11111");
        return "Order Service.";
    }

}
