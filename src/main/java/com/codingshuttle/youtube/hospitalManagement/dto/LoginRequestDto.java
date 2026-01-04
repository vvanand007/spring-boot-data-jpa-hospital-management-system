package com.codingshuttle.youtube.hospitalManagement.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
