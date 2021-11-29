package com.senla.api.service;

import com.senla.model.dto.PaymentDto;

public interface IPaymentService {
    void createPayment(PaymentDto paymentDto);

    void addPaymentToAnnouncement(Long id, PaymentDto paymentDto);
}
