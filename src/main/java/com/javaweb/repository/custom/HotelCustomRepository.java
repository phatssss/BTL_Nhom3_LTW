package com.javaweb.repository.custom;

import com.javaweb.builder.HotelSearchBuilder;
import com.javaweb.entity.HotelEntity;


import java.util.List;

public interface HotelCustomRepository {
    List<HotelEntity> findAll(HotelSearchBuilder hotelSearchBuilder);
}
