package com.senla.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating extends AbstractModel {
    @Column(name = "id")
    private Long id;
    @Column(name = "rating")
    private Double rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_to_user_id", nullable = false)
    private User ratingToUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_from_user_id", nullable = false)
    private User ratingFromUser;

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rating=" + rating +
                ", ratingToUser=" + ratingToUser +
                ", ratingFromUser=" +ratingFromUser +
                '}';
    }
}
