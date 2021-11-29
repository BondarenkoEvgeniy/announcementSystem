package com.senla.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment extends AbstractModel{
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_comment", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "announcement_id", nullable = false)
    private Announcement announcement;
    @Column(name = "comment_text")
    private String commentText;
    @Column(name = "comment_date")
    private LocalDate commentDate;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", commentText='" + commentText + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}
