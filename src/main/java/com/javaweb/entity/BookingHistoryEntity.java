package com.javaweb.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking_history")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticket;

    @Column(name = "payment")
    private String payment;

    @Column(name = "orderstatus")
    private String orderStatus;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "modifieddate")
    @LastModifiedDate
    private LocalDateTime modifiedDate;


}
