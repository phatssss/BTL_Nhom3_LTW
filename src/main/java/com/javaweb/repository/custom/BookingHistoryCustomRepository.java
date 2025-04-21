package com.javaweb.repository.custom;

import com.javaweb.model.dto.TicketTypeStatsDTO;

import java.util.List;

public interface BookingHistoryCustomRepository {
    List<TicketTypeStatsDTO> getTicketTypeStats();
}
