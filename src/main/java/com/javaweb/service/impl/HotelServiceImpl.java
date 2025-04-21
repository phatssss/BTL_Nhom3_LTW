package com.javaweb.service.impl;

import com.javaweb.builder.HotelSearchBuilder;

import com.javaweb.converter.HotelConverter;
import com.javaweb.converter.HotelSearchBuilderConverter;
import com.javaweb.entity.HotelEntity;
import com.javaweb.model.dto.HotelDTO;
import com.javaweb.model.reponse.ResponseDTO;
import com.javaweb.repository.HotelBookingRepository;
import com.javaweb.repository.HotelRepository;

import com.javaweb.service.HotelService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;


    private final HotelConverter hotelConverter;


    private final HotelBookingRepository hotelBookingRepository;

    private final HotelSearchBuilderConverter hotelSearchBuilderConverter;

    @Override
    public List<HotelDTO> getHotels() {
//        List<HotelDTO> hotelDTOList = new ArrayList<>();
        List<HotelEntity>  hotelEntities = hotelRepository.findAll();

        return hotelEntities.stream().map(hotelConverter::toHotelDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseDTO save(HotelDTO hotelDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        HotelEntity hotelEntity = hotelConverter.toHotelEntity(hotelDTO);
        if(hotelEntity.getId() != null){
            responseDTO.setMessage("Hotel Updated Successfully!!");
        }
        else {
            responseDTO.setMessage("Hotel Created Successfully!!");
        }
        hotelRepository.save(hotelEntity);
//        hotelRepository.
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteHotel(List<Integer> ids) {
        ResponseDTO responseDTO = new ResponseDTO();
        hotelBookingRepository.deleteByHotel_IdIn(ids);
        hotelRepository.deleteAllByIdIn(ids);
        responseDTO.setMessage("Hotel Deleted Successfully!!");
        return responseDTO;

    }

    @Override
    public List<HotelDTO> searchHotel(Map<String, Object> map) {
        HotelSearchBuilder hotelSearchBuilder = hotelSearchBuilderConverter.toHotelSearchBuilder(map);

        List<HotelEntity> hotelEntities = hotelRepository.findAll(hotelSearchBuilder);

        return hotelEntities.stream().map(hotelConverter::toHotelDTO).collect(Collectors.toList());

    }

}
