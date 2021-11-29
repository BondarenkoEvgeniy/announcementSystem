package com.senla.dao;

import com.senla.api.dao.IPaymentDao;
import com.senla.model.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PaymentDao extends AbstractDao<Payment> implements IPaymentDao {
    @Override
    protected Class<Payment> getClazz() {
        return Payment.class;
    }
}
