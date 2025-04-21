package com.javaweb.converter;

import com.javaweb.entity.HotelEntity;
import com.javaweb.model.dto.HotelDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HotelConverter {

    private final ModelMapper modelMapper;

    public HotelDTO toHotelDTO(HotelEntity hotelEntity) {
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    public HotelEntity toHotelEntity(HotelDTO hotelDTO) {
        return modelMapper.map(hotelDTO, HotelEntity.class);
    }


}
