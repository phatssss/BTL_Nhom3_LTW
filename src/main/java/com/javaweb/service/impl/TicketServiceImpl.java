package com.javaweb.service.impl;

import com.javaweb.builder.TicketSearchBuilder;
import com.javaweb.converter.TicketConverter;
import com.javaweb.converter.TicketSearchBuilderConverter;
import com.javaweb.entity.TicketEntity;
import com.javaweb.model.dto.TicketDTO;
import com.javaweb.model.reponse.ResponseDTO;
import com.javaweb.repository.BookingHistoryRepository;
import com.javaweb.repository.TicketRepository;
import com.javaweb.service.TicketService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;


    private final TicketConverter ticketConverter;


    private final TicketSearchBuilderConverter ticketSearchBuilderConverter;


    private final BookingHistoryRepository bookingHistoryRepository;


    @Override
    public List<TicketDTO> getAllTickets() {
        List<TicketEntity> ticketEntities = ticketRepository.findAll();
        return ticketEntities.stream().map(ticketConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<TicketDTO> getAllTicketByCondition(Map<String, Object> params) {
        // Chuyển từ Map -> class
        TicketSearchBuilder ticketSearchBuilder = ticketSearchBuilderConverter.toTicketSearchBuilder(params);

        // Lấy dữ liệu từ db thông qua entity(repo)
        List<TicketEntity> ticketEntities = ticketRepository.findAll(ticketSearchBuilder);

        List<TicketDTO> ticketDTOS = new ArrayList<>();
        for (TicketEntity ticketEntity : ticketEntities) {
            // entity -> dto để trả ra dữ liệu
            ticketDTOS.add(ticketConverter.toDTO(ticketEntity));
        }
        return ticketDTOS;
    }

    @Override
    public ResponseDTO save(TicketDTO ticketDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        TicketEntity ticketEntity = ticketConverter.toEntity(ticketDTO);
        ticketEntity.setCreatedBy("admin");
        ticketEntity.setModifiedDate(LocalDateTime.now());


        if(ticketEntity.getId() == null){
            responseDTO.setMessage("Create success!!!");

        }
        else {
            responseDTO.setMessage("Update success!!!");
        }
         ticketRepository.save(ticketEntity);
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteTickets(List<Long> ids) {
        bookingHistoryRepository.deleteByticket_IdIn(ids);
        ticketRepository.deleteAllByIdIn(ids);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Delete success!!!");
        return responseDTO;
    }

    @Override
    public TicketDTO getTicketDetails(Integer id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();
        return ticketConverter.toDTO(ticketEntity);
    }

}
