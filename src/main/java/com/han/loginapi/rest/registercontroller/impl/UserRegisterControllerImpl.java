package com.han.loginapi.rest.registercontroller.impl;

import com.han.loginapi.model.UserDTO;
import com.han.loginapi.rest.registercontroller.UserRegisterController;
import com.han.loginapi.services.register.impl.UserRegisterImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterControllerImpl implements UserRegisterController {

    private final UserRegisterImpl userRegisterImpl;

    public UserRegisterControllerImpl(UserRegisterImpl userRegisterImpl) {
        this.userRegisterImpl = userRegisterImpl;
    }


    @Override
    public ResponseEntity<String> save(UserDTO userDTO) {
        userRegisterImpl.register(userDTO);
        return new ResponseEntity<>("User saved!", HttpStatus.CREATED);
    }
}
