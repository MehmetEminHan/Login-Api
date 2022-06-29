package com.han.loginapi.rest.logincontroller.impl;

import com.han.loginapi.model.UserDTO;
import com.han.loginapi.rest.logincontroller.UserLoginController;
import com.han.loginapi.services.login.UserLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginControllerImpl implements UserLoginController {

    private final UserLogin userLogin;

    public UserLoginControllerImpl(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public ResponseEntity<String> login(UserDTO userDto) {

        if(userLogin.login(userDto)){
            return new ResponseEntity<>("Login is successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login is not successful", HttpStatus.OK);
        }

    }

}
