package com.realEstate.realEstate.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginRequest {

    private String email;
    private String password;


}
