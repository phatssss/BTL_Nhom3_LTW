package com.javaweb.converter;

import com.javaweb.builder.TicketSearchBuilder;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class TicketSearchBuilderConverter {

    public TicketSearchBuilder toTicketSearchBuilder(Map<String, Object> params) {
        return new TicketSearchBuilder.Builder()
                .setOrigin(MapUtils.getObject(params, "origin", String.class))
                .setDestination(MapUtils.getObject(params, "destination", String.class))
                .setAirline(MapUtils.getObject(params, "airline", String.class))
                .setType(MapUtils.getObject(params, "type", String.class))
                .setEstimatedTime(MapUtils.getObject(params, "estimatedTime", String.class))
                .setDepartureTimeFrom(MapUtils.getObject(params, "departureTime", LocalDateTime.class))
                .setArriveTime(MapUtils.getObject(params, "arriveTime", LocalDateTime.class))
                .setPriceFrom(MapUtils.getObject(params, "priceFrom", Long.class))
                .setPriceTo(MapUtils.getObject(params, "priceTo", Long.class))
                .build();
    }
}
