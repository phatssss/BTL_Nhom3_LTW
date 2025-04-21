package com.javaweb.converter;

import com.javaweb.builder.HotelSearchBuilder;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class HotelSearchBuilderConverter {

    public HotelSearchBuilder toHotelSearchBuilder(Map<String, Object> condition){
        return new HotelSearchBuilder.Builder()
                .setName(MapUtils.getObject(condition, "hotelName", String.class))
                .setAddress(MapUtils.getObject(condition,"address", String.class))
                .setRatingFrom(MapUtils.getObject(condition,"ratingFrom", BigDecimal.class))
                .setRatingTo(MapUtils.getObject(condition,"ratingTo", BigDecimal.class))
                .setPricePerNightFrom(MapUtils.getObject(condition,"pricePerNightFrom", Long.class))
                .setPricePerNightTo(MapUtils.getObject(condition,"pricePerNightTo", Long.class))
                .build();

    }
}
