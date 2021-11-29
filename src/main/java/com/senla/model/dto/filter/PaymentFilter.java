package com.senla.model.dto.filter;

import com.senla.model.Announcement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentFilter {
    private Long id;
    private String name;
    private Announcement announcementPayment;
    private Double price;
}
