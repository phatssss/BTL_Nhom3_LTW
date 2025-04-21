package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class HotelBookingDTO {
    private String hotelName;
    private String userFullName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomQuantity;
    private BigDecimal totalPrice;
    private LocalDateTime bookingDate;
    private String notes;
}
