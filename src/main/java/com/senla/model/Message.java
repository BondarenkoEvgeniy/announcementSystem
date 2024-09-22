package com.senla.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message extends AbstractModel{
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_to_user_id", nullable = false)
    private User messageToUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_from_user_id", nullable = false)
    private User messageFromUser;
    @Column(name = "message_text")
    private String messageText;
    @Column(name = "message_date")
    private LocalDate messageDate;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", messageToUser=" + messageToUser.getId() +
                ", messageText='" + messageText + '\'' +
                ", messageDate=" + messageDate +
                '}';
    }
}
