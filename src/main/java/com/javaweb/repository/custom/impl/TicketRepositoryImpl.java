package com.javaweb.repository.custom.impl;

import com.javaweb.builder.TicketSearchBuilder;
import com.javaweb.entity.TicketEntity;
import com.javaweb.repository.custom.TicketCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

@Repository
public class TicketRepositoryImpl implements TicketCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TicketEntity> findAll(TicketSearchBuilder ticketSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT t.* FROM ticket t WHERE 1 = 1 ");
        queryNormal(sql, ticketSearchBuilder);
        querySpecial(sql, ticketSearchBuilder);
        sql.append(" GROUP BY t.id");
        Query query = entityManager.createNativeQuery(sql.toString(), TicketEntity.class);
        return query.getResultList();
    }


    public static void queryNormal(StringBuilder sql, TicketSearchBuilder ticketSearchBuilder) {
        try {
            Field[] fields = TicketSearchBuilder.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                Object value = item.get(ticketSearchBuilder);


                if (!fieldName.endsWith("From") && !fieldName.endsWith("To")) {
                    if (value != null && !value.toString().isEmpty()) {
                        if (item.getType().getName().equals("java.lang.Long") ||
                                item.getType().getName().equals("java.lang.Integer")) {
                            sql.append("AND t.").append(fieldName).append(" = ").append(value).append(" ");
                        } else {
                            sql.append("AND t.").append(fieldName).append(" LIKE '%").append(value).append("%' ");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void querySpecial(StringBuilder sql, TicketSearchBuilder builder) {
        if (builder.getPriceFrom() != null) {
            sql.append("AND t.price >= ").append(builder.getPriceFrom()).append(" ");
        }
        if (builder.getPriceTo() != null) {
            sql.append("AND t.price <= ").append(builder.getPriceTo()).append(" ");
        }
        if (builder.getDepartureTimeFrom() != null) {
            sql.append("AND t.departureTime >= '").append(builder.getDepartureTimeFrom()).append("' ");
        }
        if (builder.getArriveTime() != null) {
            sql.append("AND t.arriveTime <= '").append(builder.getArriveTime()).append("' ");
        }
    }

}
