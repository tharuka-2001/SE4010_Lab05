package com.example.order_service;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private List<String> orders = new ArrayList<>();

    @GetMapping
    public List<String> getOrders() {
        return orders;
    }

    @PostMapping
    public String addOrder(@RequestBody String order) {
        orders.add(order);
        return "Order added successfully";
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable int id) {
        if (id < orders.size()) {
            return orders.get(id);
        }
        return "Order not found";
    }
}