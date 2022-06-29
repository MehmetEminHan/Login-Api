package com.han.loginapi.rest.registercontroller;

import com.han.loginapi.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/register")
public interface UserRegisterController {
    @PostMapping()
    ResponseEntity<String> save(@RequestBody UserDTO userDTO);
}
