package com.han.loginapi.rest.logoutcontroller.impl;

import com.han.loginapi.model.UserDTO;
import com.han.loginapi.rest.logoutcontroller.UserLogoutController;
import com.han.loginapi.services.logout.UserLogout;
import com.han.loginapi.services.logout.impl.UserLogoutImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLogoutControllerImpl implements UserLogoutController {

    private final UserLogoutImpl userLogout;

    public UserLogoutControllerImpl(UserLogoutImpl userLogout) {
        this.userLogout = userLogout;
    }

    @Override
    public ResponseEntity<String> changeToIsLogin(UserDTO userDTO) {
        userLogout.userLogout(userDTO);
        return new ResponseEntity<>("Logout is successful", HttpStatus.OK);
    }
}
