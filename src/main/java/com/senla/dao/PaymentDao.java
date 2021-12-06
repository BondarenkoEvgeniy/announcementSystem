package com.senla.dao;

import com.senla.api.dao.IPaymentDao;
import com.senla.model.Payment;
import com.senla.model.dto.filter.PaymentFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PaymentDao extends AbstractDao<Payment> implements IPaymentDao {
    @Override
    protected Class<Payment> getClazz() {
        return Payment.class;
    }

    @Override
    public List<Payment> getByFilter(PaymentFilter paymentFilter) {
        return null;
    }
}
