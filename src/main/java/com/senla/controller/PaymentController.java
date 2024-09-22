package com.senla.controller;

import com.senla.api.service.IPaymentService;
import com.senla.model.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @PostMapping
    public ResponseEntity<Void> createPayment(@RequestBody PaymentDto paymentDto) {
        paymentService.createPayment(paymentDto);
        return ResponseEntity.noContent().build();
    }


}
