package com.javaweb.model.dto;

//import com.javaweb.entity.BookingHistoryEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class BookingHistoryDTO {

    private Integer id;
    private String fullNameCustomer;
    private String airlineName;
    private String origin;
    private String destination;
    private String typeTicket;
    private String payment;
    private String orderStatus;
    private Integer quantity;
    private Long totalPrice;
    private LocalDateTime modifiedDate;

}
