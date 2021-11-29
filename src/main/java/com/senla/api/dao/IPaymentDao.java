package com.senla.api.dao;

import com.senla.model.Payment;

import java.util.List;

public interface IPaymentDao {
    Payment getById(Long id);

    void save (Payment payment);

    Payment update(Payment payment);

    void delete(Payment payment);

    List<Payment> getAll();
}
