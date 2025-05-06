package com.javaweb.api.customer;

import com.javaweb.model.dto.TicketDTO;
import com.javaweb.model.request.BookingRequestDTO;
import com.javaweb.service.BookingHistoryService;
import com.javaweb.service.TicketService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer/ticket")
@Transactional
@RequiredArgsConstructor
public class TicketApi {

    private final TicketService ticketService;

    private final BookingHistoryService bookingHistoryService;

    @GetMapping("/search")
    public List<TicketDTO> getTicketByCondition(@RequestParam Map<String, Object> params) {
        return ticketService.getAllTicketByCondition(params);
    }

    @GetMapping("/{id}")
    public TicketDTO getTicketDetails(@PathVariable Integer id) {
        return ticketService.getTicketDetails(id);
    }

    @PostMapping
    public ResponseEntity<?> bookTicket(@RequestBody BookingRequestDTO bookingRequestDTO, Principal principal) {
        return ResponseEntity.ok("Oke");
    }

}
