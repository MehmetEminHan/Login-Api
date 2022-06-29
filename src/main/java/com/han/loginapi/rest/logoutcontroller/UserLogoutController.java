package com.han.loginapi.rest.logoutcontroller;

import com.han.loginapi.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/logout")
public interface UserLogoutController {

    @PostMapping
    ResponseEntity<String> changeToIsLogin(@RequestBody UserDTO userDTO);
}
