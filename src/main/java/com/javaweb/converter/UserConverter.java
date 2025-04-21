package com.javaweb.converter;

import com.javaweb.entity.RoleEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toUserDTO(UserEntity item) {
        UserDTO userDTO = modelMapper.map(item, UserDTO.class);
        if(item.getRole()!=null) {
            userDTO.setRoleCode(item.getRole().getCode());
        }
        return userDTO;
    }

    public UserEntity toUserEntity(UserDTO item) {

        // Thiết lập vai trò nếu roleCode được cung cấp và khác với vai trò hiện tại


        return modelMapper.map(item, UserEntity.class);
    }

}
