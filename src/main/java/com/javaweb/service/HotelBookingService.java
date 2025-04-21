package com.javaweb.service;

import com.javaweb.model.dto.HotelBookingDTO;

import com.javaweb.model.dto.HotelPriceStatsDTO;


import java.util.List;

//@Service
public interface HotelBookingService {
//    ResponseDTO deleteHotels(List<Integer> ids);
    List<HotelBookingDTO> getAllHotelBookings();

    List<HotelPriceStatsDTO> getStats();
}
