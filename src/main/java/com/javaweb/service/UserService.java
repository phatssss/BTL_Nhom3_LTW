package com.javaweb.service;

import com.javaweb.model.request.LoginRequest;
import com.javaweb.model.request.RegisterRequest;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.reponse.ResponseDTO;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsersWithoutStatus();
    List<UserDTO> getAllUsers(Pageable pageable);
    List<UserDTO> getUserByCondition(String str, Boolean status);




    ResponseDTO updateUser(UserDTO UserDTO);

    ResponseDTO deleteUser(List<Integer> id);

    String register(RegisterRequest registerRequest);
    String login(LoginRequest loginRequest);

    UserDTO getCustomerProfile(Integer id);

}
