package com.javaweb.service.impl;

import com.javaweb.converter.BookingHistoryConverter;
import com.javaweb.entity.BookingHistoryEntity;

import com.javaweb.entity.TicketEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BookingHistoryDTO;
import com.javaweb.model.dto.TicketTypeStatsDTO;
import com.javaweb.model.request.BookingRequestDTO;
import com.javaweb.repository.BookingHistoryRepository;

import com.javaweb.repository.TicketRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BookingHistoryService;
import jakarta.transaction.Transactional;

import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional

public class BookingHistoryServiceImpl implements BookingHistoryService {

    private final UserRepository user;

    private final TicketRepository ticket;

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

    @Override
    public void bookTicket(BookingRequestDTO dto, String username) {
        UserEntity userEntity = user.findByUserName(username);
        TicketEntity ticketEntity = ticket.findById(dto.getTicketId()).get();

        BookingHistoryEntity booking = BookingHistoryEntity.builder()
                .user(userEntity)
                .ticket(ticketEntity)
                .payment("PENDING")
                .orderStatus("CONFIRMED")
                .quantity(1)
                .modifiedDate(LocalDateTime.now())
                .build();
        bookingHistoryRepository.save(booking);

    }

    @Override
    public List<BookingHistoryDTO> getBookingHistoryByUser(Integer userId) {
        List<BookingHistoryEntity> list = bookingHistoryRepository.findAllByUserId(userId);
        return list.stream().map(bookingHistoryConverter::bookingHistoryDTO).collect(Collectors.toList());
    }

    @Override
    public void cancelTicket(BookingHistoryDTO dto) {


        BookingHistoryEntity bookingHistory = bookingHistoryRepository.findById(dto.getId()).get();
        bookingHistory.setOrderStatus("CANCELLED");
        bookingHistory.setModifiedDate(LocalDateTime.now());
        bookingHistoryRepository.save(bookingHistory);

    }
}
