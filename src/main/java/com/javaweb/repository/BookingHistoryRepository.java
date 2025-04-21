package com.javaweb.repository;

import com.javaweb.entity.BookingHistoryEntity;
import com.javaweb.repository.custom.BookingHistoryCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookingHistoryRepository extends JpaRepository<BookingHistoryEntity, Integer>, BookingHistoryCustomRepository {
    void deleteByticket_IdIn(List<Long> ticketids);
}
