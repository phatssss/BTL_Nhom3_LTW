package com.javaweb.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "hotel_booking")
public class HotelBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @Column(name ="checkin_date")
    private LocalDate checkInDate;

    @Column(name ="checkout_date")
    private LocalDate checkOutDate;

    @Column(name = "room_quantity")
    private Integer roomQuantity;

    @Column(name ="total_price")
    private BigDecimal totalPrice;

    @Column(name ="status")
    private String status;

    @Column(name ="booking_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime bookingDate;

    @Column(name = "notes")
    private String notes;









}
