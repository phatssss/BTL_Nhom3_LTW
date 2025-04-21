package com.javaweb.service.impl;

import com.javaweb.converter.BookingHistoryConverter;
import com.javaweb.entity.BookingHistoryEntity;

import com.javaweb.model.dto.BookingHistoryDTO;
import com.javaweb.model.dto.TicketTypeStatsDTO;
import com.javaweb.repository.BookingHistoryRepository;

import com.javaweb.service.BookingHistoryService;
import jakarta.transaction.Transactional;

import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@Transactional
@AllArgsConstructor
public class BookingHistoryServiceImpl implements BookingHistoryService {


    private final BookingHistoryRepository bookingHistoryRepository;


    private final BookingHistoryConverter bookingHistoryConverter;


    @Override
    public List<BookingHistoryDTO> getBookingHistory() {
        List<BookingHistoryEntity> bookingHistoryEntities = bookingHistoryRepository.findAll();
        return bookingHistoryEntities.stream().map(bookingHistoryConverter::bookingHistoryDTO).collect(Collectors.toList());
    }

    @Override
    public List<TicketTypeStatsDTO> getTicketTypeRouteStats() {
        return bookingHistoryRepository.getTicketTypeStats();
    }
}
