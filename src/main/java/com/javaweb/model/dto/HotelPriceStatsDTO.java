package com.javaweb.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class HotelPriceStatsDTO {
    private String hotelName;
    private Long totalPriceHotel;
}
