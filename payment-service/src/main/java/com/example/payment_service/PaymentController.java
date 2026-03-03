package com.example.payment_service;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private List<String> payments = new ArrayList<>();

    @GetMapping
    public List<String> getPayments() {
        return payments;
    }

    @PostMapping("/process")
    public String processPayment(@RequestBody String payment) {
        payments.add(payment);
        return "Payment processed successfully";
    }

    @GetMapping("/{id}")
    public String getPayment(@PathVariable int id) {
        if (id < payments.size()) {
            return payments.get(id);
        }
        return "Payment not found";
    }
}