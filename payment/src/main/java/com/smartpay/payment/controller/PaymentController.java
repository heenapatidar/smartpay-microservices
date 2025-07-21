package com.smartpay.payment.controller;

import com.smartpay.payment.entity.Payment;
import com.smartpay.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @GetMapping("/sender/{senderId}")
    public List<Payment> getPaymentsBySender(@PathVariable Long senderId) {
        return paymentRepository.findBySenderAccountId(senderId);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
