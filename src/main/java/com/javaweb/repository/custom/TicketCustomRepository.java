package com.javaweb.repository.custom;

import com.javaweb.builder.TicketSearchBuilder;
import com.javaweb.entity.TicketEntity;

import java.util.List;

public interface TicketCustomRepository {
    List<TicketEntity> findAll(TicketSearchBuilder ticketSearchBuilder);
}
