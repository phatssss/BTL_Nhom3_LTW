package com.javaweb.repository;

import com.javaweb.entity.HotelBookingEntity;
import com.javaweb.repository.custom.HotelBookingCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

//@Repository
public interface HotelBookingRepository  extends JpaRepository<HotelBookingEntity, Integer>, HotelBookingCustomRepository {
    void deleteByHotel_IdIn(List<Integer> ids);
}
