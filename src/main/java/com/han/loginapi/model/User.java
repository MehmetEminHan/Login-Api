package com.han.loginapi.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userId;
    private String email;
    private String userName;
    private String password;
    private Boolean isLogin;
}
