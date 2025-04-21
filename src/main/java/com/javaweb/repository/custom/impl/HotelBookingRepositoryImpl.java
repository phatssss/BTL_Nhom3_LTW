package com.javaweb.repository.custom.impl;

import com.javaweb.model.dto.HotelPriceStatsDTO;

import com.javaweb.repository.custom.HotelBookingCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.stream.Collectors;

//@RequestMapping
@Repository
public class HotelBookingRepositoryImpl implements HotelBookingCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<HotelPriceStatsDTO> getTotalPriceStats() {
        StringBuilder sql = new StringBuilder("SELECT h.name, SUM(hb.total_price) "
                + " FROM hotel_booking hb "
                + " JOIN hotel h ON hb.hotel_id = h.id "
                + " GROUP BY h.name ");

        Query query = entityManager.createNativeQuery(sql.toString());

        List<Object[]> result = query.getResultList();

        return result.stream().map(row -> new HotelPriceStatsDTO(
                (String) row[0],
                ((Number) row[1]).longValue()
        )).collect(Collectors.toList());
    }
}
