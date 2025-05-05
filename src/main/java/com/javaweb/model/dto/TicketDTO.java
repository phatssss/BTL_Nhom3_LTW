package com.javaweb.model.dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class TicketDTO  {

    private Integer id;

    private String airline;


    private String origin;


    private String destination;


    private String estimatedTime;


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime departureTime;


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime arriveTime;


    private String type;


    private Long price;
}
