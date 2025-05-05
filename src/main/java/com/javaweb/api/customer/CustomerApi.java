package com.javaweb.api.customer;


import com.javaweb.model.dto.UserDTO;
import com.javaweb.service.UserService;
import jakarta.transaction.Transactional;
//import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer/profile")
@Transactional
@RequiredArgsConstructor
public class CustomerApi {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getCustomerProfile(@PathVariable Integer id) {
        return userService.getCustomerProfile(id);
    }

}
