package com.javaweb.service;

import com.javaweb.model.dto.BookingHistoryDTO;
import com.javaweb.model.dto.TicketTypeStatsDTO;

import java.util.List;

public interface BookingHistoryService {
    List<BookingHistoryDTO> getBookingHistory();
    List<TicketTypeStatsDTO> getTicketTypeRouteStats();
}
