package com.javaweb.api.admin;


import com.javaweb.model.dto.HotelBookingDTO;
import com.javaweb.model.dto.HotelPriceStatsDTO;

import com.javaweb.service.HotelBookingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/admin/hotel/booking")
@RequiredArgsConstructor
public class HotelBookingAPI {


    private final HotelBookingService hotelBookingService;

    @GetMapping
    public List<HotelBookingDTO> getHotelBookings() {

        return hotelBookingService.getAllHotelBookings();
    }

    @GetMapping("/hotel-price-stats")
    public List<HotelPriceStatsDTO> getHotelPriceStats() {
        return hotelBookingService.getStats();
    }

}
