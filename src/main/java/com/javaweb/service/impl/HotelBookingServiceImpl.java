package com.javaweb.service.impl;


import com.javaweb.converter.HotelBookingConverter;
import com.javaweb.entity.HotelBookingEntity;
import com.javaweb.model.dto.HotelBookingDTO;
import com.javaweb.model.dto.HotelPriceStatsDTO;
import com.javaweb.repository.HotelBookingRepository;
import com.javaweb.service.HotelBookingService;
import jakarta.transaction.Transactional;

import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class HotelBookingServiceImpl implements HotelBookingService {


    private final HotelBookingRepository hotelBookingRepository;

    private final HotelBookingConverter  hotelBookingConverter;

    @Override
    public List<HotelBookingDTO> getAllHotelBookings() {
        List<HotelBookingEntity> hotelBookingEntityList = hotelBookingRepository.findAll();

        return hotelBookingEntityList.stream().map(hotelBookingConverter::toHotelBookingDTO).collect(Collectors.toList());
    }

    @Override
    public List<HotelPriceStatsDTO> getStats() {
        return hotelBookingRepository.getTotalPriceStats();
    }
}
