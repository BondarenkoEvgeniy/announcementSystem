package com.senla.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment extends AbstractModel{
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "announcement_id", nullable = false)
    private Announcement announcementPayment;
    @Column(name = "price", nullable = false)
    private Double price;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", announcementPayment=" + announcementPayment +
                ", price=" + price +
                '}';
    }
}
