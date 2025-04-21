package com.javaweb.repository;


import com.javaweb.entity.HotelEntity;
import com.javaweb.repository.custom.HotelCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import  java.util.List;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer>, HotelCustomRepository {
    void deleteAllByIdIn(List<Integer> ids);
}
