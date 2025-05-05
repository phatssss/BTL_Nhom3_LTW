package com.javaweb.service;

import com.javaweb.model.dto.TicketDTO;
import com.javaweb.model.reponse.ResponseDTO;

import java.util.*;

public interface TicketService {

    List<TicketDTO> getAllTickets();

    List<TicketDTO> getAllTicketByCondition(Map<String, Object> params) ;

    ResponseDTO save(TicketDTO ticketDTO);

    ResponseDTO deleteTickets(List<Long> ids);

    TicketDTO getTicketDetails(Integer id);
}
