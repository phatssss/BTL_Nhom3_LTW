package com.javaweb.service.impl;

import com.javaweb.converter.UserConverter;
import com.javaweb.entity.RoleEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.reponse.ResponseDTO;
import com.javaweb.repository.RoleRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    private final UserConverter userConverter;

    private final RoleRepository roleRepository;

    @Override
    public List<UserDTO> getAllUsersWithoutStatus() {
        List<UserEntity> userEntities = userRepository.findAll();
//        userRepository.
        List<UserDTO> userDTOs = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userDTOs.add(userConverter.toUserDTO(userEntity));
        }
        return userDTOs;
    }

    @Override
    public List<UserDTO> getAllUsers(Pageable pageable) {
        List<UserEntity> userEntities = userRepository.getAllUsers(pageable);
        List<UserDTO> userDTOs = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userDTOs.add(userConverter.toUserDTO(userEntity));
        }
        return userDTOs;
    }

    @Override
    public List<UserDTO> getUserByCondition(String str, Boolean status) {
        List<UserEntity> userEntities = new ArrayList<>();
        if (str == null || str.equals("")) {
            userEntities = userRepository.findByStatus(status);
        } else {
            userEntities = userRepository.findByFullNameContainingIgnoreCaseOrAddressContainingIgnoreCase(str, str);
        }
        List<UserDTO> userDTOs = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userDTOs.add(userConverter.toUserDTO(userEntity));
        }
        return userDTOs;
    }

    @Override
    public ResponseDTO updateUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.toUserEntity(userDTO);
        RoleEntity role = roleRepository.findByCode("CUSTOMER");
        ResponseDTO responseDTO = new ResponseDTO();
        if (userDTO.getId() != null) {
            responseDTO.setMessage("update user successful");
        } else {
            responseDTO.setMessage("Add successful");
            userEntity.setRole(role);
        }
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.toUserDTO(userEntity);
        responseDTO.setData(userDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteUser(List<Integer> ids) {
        int sum = 0;
       for(Integer itemId : ids) {
           UserEntity userEntity = userRepository.findById(itemId).get();
           userEntity.setStatus(false);
           userRepository.save(userEntity);
           sum+= 1;
       }
       ResponseDTO responseDTO = new ResponseDTO();
       if(sum<ids.size()) {
           responseDTO.setMessage("delete user failed");
       }
       else
           responseDTO.setMessage("delete user successful");
       return responseDTO;

    }
}
