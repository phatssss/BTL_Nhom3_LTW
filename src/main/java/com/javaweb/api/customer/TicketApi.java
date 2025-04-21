package com.javaweb.api.customer;

import com.javaweb.model.dto.TicketDTO;
import com.javaweb.service.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer/ticket")
@Transactional
public class TicketApi {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/search")
    public List<TicketDTO> getTicketByCondition(@RequestParam Map<String, Object> params) {
        return ticketService.getAllTicketByCondition(params);
    }

}
