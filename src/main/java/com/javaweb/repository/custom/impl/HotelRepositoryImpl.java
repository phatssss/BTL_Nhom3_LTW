package com.javaweb.repository.custom.impl;

import com.javaweb.builder.HotelSearchBuilder;
import com.javaweb.entity.HotelEntity;

import com.javaweb.repository.custom.HotelCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HotelEntity> findAll(HotelSearchBuilder hotelSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT h.* FROM hotel h WHERE 1=1 ");
        queryNormal(hotelSearchBuilder,sql);
        querySpecial(sql, hotelSearchBuilder);
        Query query = entityManager.createNativeQuery(sql.toString(), HotelEntity.class);

        return query.getResultList();
    };

    public static void queryNormal(HotelSearchBuilder hotelSearchBuilder, StringBuilder sql) {
        try {
            Field[] fields = HotelSearchBuilder.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                Object value = item.get(hotelSearchBuilder);

                if (!fieldName.endsWith("From") && !fieldName.endsWith("To")) {
                    if (value != null && !value.toString().isEmpty()) {
                        if (item.getType().getName().equals("java.lang.Long") ||
                                item.getType().getName().equals("java.lang.Integer")) {
                            sql.append("AND h.").append(fieldName).append(" = ").append(value).append(" ");
                        } else {
                            sql.append("AND h.").append(fieldName).append(" LIKE '%").append(value).append("%' ");
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void querySpecial(StringBuilder sql, HotelSearchBuilder builder) {
        if(builder.getRatingFrom() != null) {
            sql.append("AND h.rating >= ").append(builder.getRatingFrom()).append(" ");
        }
        if(builder.getRatingTo() != null) {
            sql.append("AND h.rating <= ").append(builder.getRatingTo()).append(" ");
        }
        if(builder.getPricePerNightFrom() != null) {
            sql.append("AND h.price_per_night >= ").append(builder.getPricePerNightFrom()).append(" ");
        }
        if(builder.getPricePerNightTo() != null) {
            sql.append("AND h.price_per_night <= ").append(builder.getPricePerNightTo()).append(" ");
        }
    }
}
