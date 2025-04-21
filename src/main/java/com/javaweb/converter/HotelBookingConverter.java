package com.javaweb.converter;

import com.javaweb.entity.HotelBookingEntity;
import com.javaweb.entity.HotelEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.HotelBookingDTO;
import com.javaweb.repository.HotelRepository;
import com.javaweb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HotelBookingConverter {

    private final ModelMapper modelMapper;

    private final HotelRepository hotelRepository;

    private final UserRepository userRepository;


    public HotelBookingDTO toHotelBookingDTO(HotelBookingEntity hotelBookingEntity) {
        HotelBookingDTO hotelBookingDTO = modelMapper.map(hotelBookingEntity, HotelBookingDTO.class);
        UserEntity userEntity = userRepository.findById(hotelBookingEntity.getUserEntity().getId()).get();
        HotelEntity hotelEntity = hotelRepository.findById(hotelBookingEntity.getHotel().getId()).get();
        hotelBookingDTO.setHotelName(hotelEntity.getName());
        hotelBookingDTO.setUserFullName(userEntity.getFullName());
        return hotelBookingDTO;
    }


}
