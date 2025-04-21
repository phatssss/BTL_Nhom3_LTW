package com.javaweb.api.admin;

import com.javaweb.model.dto.TicketDTO;
import com.javaweb.model.reponse.ResponseDTO;
import com.javaweb.service.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import sun.security.krb5.internal.Ticket;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/ticket")
@Transactional
public class TicketAPI {

    @Autowired
    private TicketService ticketService;

    // Lấy ra danh sách vé

    @GetMapping
    public List<TicketDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/search")
    public List<TicketDTO> getTicketByCondition(@RequestParam Map<String, Object> params) {
        return ticketService.getAllTicketByCondition(params);
    }


    //thêm hoặc sửa vé
    @PostMapping
    public ResponseDTO createOrUpdateTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.save(ticketDTO);
    }


    // Xóa vé
    @DeleteMapping("/{ids}")
    public ResponseDTO deleteTickets(@PathVariable List<Long> ids) {
        return ticketService.deleteTickets(ids);
    }




}
