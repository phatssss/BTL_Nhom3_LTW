package com.javaweb.repository.custom;

import com.javaweb.model.dto.HotelPriceStatsDTO;

import java.util.List;

public interface HotelBookingCustomRepository {
    List<HotelPriceStatsDTO> getTotalPriceStats();
}
