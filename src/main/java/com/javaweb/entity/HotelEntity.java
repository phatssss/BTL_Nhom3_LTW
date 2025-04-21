package com.javaweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="hotel")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name ="rating")
    private BigDecimal rating;

    @Column(name = "price_per_night")
    private Long pricePerNight;

    @Column(name = "createdby")
    private String createdBy;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade ={CascadeType.MERGE,CascadeType.PERSIST})
    private List<HotelBookingEntity> hotelBookingEntityList = new ArrayList<>();


}
