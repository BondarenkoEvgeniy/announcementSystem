package com.senla.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "announcement")
public class Announcement extends AbstractModel{
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "description", nullable = false)
    private String Description;
    @Column(name = "posting_date", nullable = false)
    private LocalDate postingDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "announcement")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Comment> comments;
    @Column(name = "announcement_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AnnouncementStatus announcementStatus;
    @Column(name = "price", nullable = false)
    private Double price;

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user.getId() +
                ", Description='" + Description + '\'' +
                ", postingDate=" + postingDate +
                ", comments=" + comments +
                ", announcementStatus=" + announcementStatus +
                ", price=" + price +
                '}';
    }
}
