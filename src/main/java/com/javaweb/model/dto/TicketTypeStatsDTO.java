package com.javaweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketTypeStatsDTO {
    private String ticketType;
    private String origin;
    private String destination;
    private Long totalSold;
    private Long totalRevenue;
}
