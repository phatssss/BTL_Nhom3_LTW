package com.javaweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ticket")
//@Builder
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
//@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "airline")
    private String airline;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "estimatedtime")
    private String estimatedTime;

    @Column(name = "departuretime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime departureTime;

    @Column(name = "arrivetime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime arriveTime;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Long price;

    @LastModifiedDate
    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;

    @CreatedBy
    @Column(name = "createdby", updatable = false)
    private String createdBy;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<BookingHistoryEntity> bookingHistoryEntityList = new ArrayList<>();
}

