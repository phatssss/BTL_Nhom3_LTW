package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class HotelDTO {

    private Integer id;
    private String hotelName;
    private String address;
    private String contactInfo;
    private BigDecimal rating;
    private Long pricePerNight;
    private String createdBy;

}
