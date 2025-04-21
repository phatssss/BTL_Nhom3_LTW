package com.javaweb.repository.custom.impl;

import com.javaweb.model.dto.TicketTypeStatsDTO;
import com.javaweb.repository.custom.BookingHistoryCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookingHistoryRepositoryImpl implements BookingHistoryCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TicketTypeStatsDTO> getTicketTypeStats() {
        StringBuilder sql = new StringBuilder("SELECT t.type, t.origin, t.destination, SUM(bh.quantity), SUM(bh.quantity * t.price) " +
                "FROM booking_history bh "
                + "JOIN ticket t ON bh.ticket_id = t.id "
                + "GROUP BY t.type , t.origin, t.destination ");
        Query query = entityManager.createNativeQuery(sql.toString());
        List<Object[]> resultList = query.getResultList();
        return resultList.stream().map(row -> new TicketTypeStatsDTO(
                (String) row[0],
                (String) row[1],
                (String) row[2],
                ((Number) row[3]).longValue(),
                ((Number) row[4]).longValue()
        )).collect(Collectors.toList());


    }
}
