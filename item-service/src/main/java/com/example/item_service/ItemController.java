package com.example.item_service;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private List<String> items = new ArrayList<>();

    @GetMapping
    public List<String> getItems() {
        return items;
    }

    @PostMapping
    public String addItem(@RequestBody String item) {
        items.add(item);
        return "Item added successfully";
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable int id) {
        if (id < items.size()) {
            return items.get(id);
        }
        return "Item not found";
    }
}