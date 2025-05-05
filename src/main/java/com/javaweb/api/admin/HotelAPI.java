package com.javaweb.api.admin;

import com.javaweb.model.dto.HotelDTO;
import com.javaweb.model.reponse.ResponseDTO;
import com.javaweb.service.HotelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/hotel")
@Transactional
@RequiredArgsConstructor
public class HotelAPI {



    private final HotelService hotelService;


    @GetMapping
    public List<HotelDTO> getHotels() {
        return hotelService.getHotels();
    }

    @GetMapping("/search")
    public List<HotelDTO> getHotelsByCondition(@RequestParam Map<String, Object> condition) {
        return hotelService.searchHotel(condition);
    }

    @PostMapping
    public ResponseDTO createOrAddHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.save(hotelDTO);
    }

    @DeleteMapping("/{ids}")
    public ResponseDTO deleteHotels(@PathVariable("ids") List<Integer> ids) {
        return hotelService.deleteHotel(ids);
    }

}
