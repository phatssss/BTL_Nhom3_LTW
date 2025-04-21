package com.javaweb.service;


import com.javaweb.model.dto.HotelDTO;
import com.javaweb.model.reponse.ResponseDTO;

import java.util.List;
import java.util.Map;

public interface HotelService {

    List<HotelDTO> getHotels();

    ResponseDTO save(HotelDTO hotelDTO);
    ResponseDTO deleteHotel(List<Integer> ids);

    List<HotelDTO> searchHotel(Map<String, Object> map);
}
