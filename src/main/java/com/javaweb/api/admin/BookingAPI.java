package com.javaweb.api.admin;

import com.javaweb.model.dto.BookingHistoryDTO;
import com.javaweb.model.dto.TicketTypeStatsDTO;
import com.javaweb.service.BookingHistoryService;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/admin/booking")
public class BookingAPI {

    @Autowired
    private BookingHistoryService bookingHistoryService;


    // Lấy ra danh sách booking
    @GetMapping
    public List<BookingHistoryDTO> getBookingHistory() {
        return bookingHistoryService.getBookingHistory();
    }

    // Thống kê ra loại vé, điểm đi điểm đến, tổng bán được và tổng thu nhập
    @GetMapping("/ticket-type-route-stats")
    public List<TicketTypeStatsDTO> getTicketTypeRouteStats() {
        return bookingHistoryService.getTicketTypeRouteStats();
    }
}
