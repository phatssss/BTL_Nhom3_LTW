package com.javaweb.model.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@EqualsAndHashCode(callSuper = true)
@Getter
@Setter

public class UserDTO {

    private Integer id;
    private String fullName;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String address;
    private Boolean status;
    private Integer roleId;
    private String roleCode;

}
