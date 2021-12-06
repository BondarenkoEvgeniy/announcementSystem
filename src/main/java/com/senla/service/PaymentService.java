package com.senla.service;

import com.senla.api.dao.IAnnouncementDao;
import com.senla.api.dao.IPaymentDao;
import com.senla.api.service.IPaymentService;
import com.senla.config.ExtendedModelMapper;
import com.senla.model.Announcement;
import com.senla.model.AnnouncementStatus;
import com.senla.model.Payment;
import com.senla.model.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private IPaymentDao paymentDao;
    @Autowired
    private IAnnouncementDao announcementDao;
    @Autowired
    private ExtendedModelMapper modelMapper;

    @Override
    public void createPayment(PaymentDto paymentDto) {
        Payment payment = modelMapper.map( paymentDto, Payment.class );
        paymentDao.save( payment );
    }

    @Override
    public void addPaymentToAnnouncement(Long id, PaymentDto paymentDto) {
        Announcement announcement = announcementDao.getById(id);
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        if(announcement.getAnnouncementStatus() != AnnouncementStatus.SPECIAL){
            announcement.setAnnouncementStatus( AnnouncementStatus.SPECIAL );
        }
        announcementDao.update(announcement);
    }
}
