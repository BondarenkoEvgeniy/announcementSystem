package com.senla.model.dto;

import com.senla.model.Announcement;
import lombok.Data;

@Data
public class PaymentDto {
    private Long id;
    private String name;
    private Announcement announcementPayment;
    private Double price;
}
