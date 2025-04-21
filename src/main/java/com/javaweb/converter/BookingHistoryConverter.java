package com.javaweb.converter;

import com.javaweb.entity.BookingHistoryEntity;
import com.javaweb.entity.TicketEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BookingHistoryDTO;
import com.javaweb.repository.HotelRepository;
import com.javaweb.repository.TicketRepository;
import com.javaweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingHistoryConverter {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;
    private final TicketRepository  ticketRepository;
    public BookingHistoryDTO bookingHistoryDTO(BookingHistoryEntity bookingHistoryEntity) {
        BookingHistoryDTO bookingHistoryDTO = modelMapper.map(bookingHistoryEntity, BookingHistoryDTO.class);

        UserEntity user = userRepository.findById(bookingHistoryEntity.getUser().getId()).get();
        TicketEntity ticket = ticketRepository.findById(bookingHistoryEntity.getTicket().getId()).get();
        bookingHistoryDTO.setFullNameCustomer(user.getFullName());
        bookingHistoryDTO.setOrigin(ticket.getOrigin());
        bookingHistoryDTO.setDestination(ticket.getDestination());
        bookingHistoryDTO.setTypeTicket(ticket.getType());
        bookingHistoryDTO.setTotalPrice(bookingHistoryEntity.getQuantity().longValue() * ticket.getPrice());
        return bookingHistoryDTO;
    }
}
