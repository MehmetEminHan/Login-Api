package com.han.loginapi.rest.logincontroller;

import com.han.loginapi.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Login")
public interface UserLoginController {

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserDTO userDto);

}
