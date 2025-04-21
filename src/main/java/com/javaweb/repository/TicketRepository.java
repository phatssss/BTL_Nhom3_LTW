package com.javaweb.repository;

import com.javaweb.entity.TicketEntity;
import com.javaweb.repository.custom.TicketCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TicketRepository extends JpaRepository<TicketEntity, Integer> , TicketCustomRepository {
    void deleteAllByIdIn(List<Long> ids);
}
