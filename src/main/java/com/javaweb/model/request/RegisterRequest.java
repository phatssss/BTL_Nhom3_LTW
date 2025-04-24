package com.javaweb.model.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String fullName;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String address;
    private Integer roleId;
}
