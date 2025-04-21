package com.javaweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name= "role_id")
    private RoleEntity role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<BookingHistoryEntity> bookingHistoryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<HotelBookingEntity> hotelBookingEntityList = new ArrayList<>();

}
