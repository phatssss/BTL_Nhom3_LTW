package com.javaweb.api.customer;


import com.javaweb.model.dto.HotelDTO;
import com.javaweb.service.HotelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer/hotel")
@Transactional
@RequiredArgsConstructor
public class HotelApi {


    private final HotelService hotelService;

    @GetMapping("/search")
    public List<HotelDTO> getHotelsByCondition(@RequestParam Map<String, Object> condition) {
        return hotelService.searchHotel(condition);
    }
}
