package com.javaweb.service;

import com.javaweb.model.dto.BookingHistoryDTO;
import com.javaweb.model.dto.TicketTypeStatsDTO;
import com.javaweb.model.request.BookingRequestDTO;

import java.util.List;

public interface BookingHistoryService {
    List<BookingHistoryDTO> getBookingHistory();
    List<TicketTypeStatsDTO> getTicketTypeRouteStats();

    void bookTicket(BookingRequestDTO dto, String username);
    List<BookingHistoryDTO> getBookingHistoryByUser(Integer userId);
    void cancelTicket(BookingHistoryDTO bookingHistoryDTO);
}
