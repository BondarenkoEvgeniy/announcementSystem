package com.senla.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User extends AbstractModel{
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Announcement> announcements;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageToUser")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Message> messages;
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Column(name = "registration_date")
    private LocalDate registrationDate;

}
