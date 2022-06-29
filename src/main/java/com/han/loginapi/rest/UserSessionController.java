package com.han.loginapi.rest;

import com.han.loginapi.model.User;
import com.han.loginapi.services.sessions.UserLogin;
import com.han.loginapi.services.sessions.UserLogout;
import com.han.loginapi.services.sessions.UserRegister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/user")
@RestController
public class UserSessionController {

    private final UserLogin userLogin;
    private final UserLogout userLogout;
    private final UserRegister userRegister;

    public UserSessionController(UserLogin userLogin, UserLogout userLogout, UserRegister userRegister){
        this.userLogin = userLogin;
        this.userLogout = userLogout;
        this.userRegister = userRegister;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        if (userLogin.login(user)) {
            return new ResponseEntity<>("Login is successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login is not successful", HttpStatus.OK);
        }

    }
    @PostMapping("/logout")
    public ResponseEntity<String> changeToIsLogin(@RequestBody User user) {
        userLogout.userLogout(user);
        return new ResponseEntity<>("Logout is successful", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> save(@RequestBody User user) {
        userRegister.register(user);
        return new ResponseEntity<>("User saved!", HttpStatus.CREATED);
    }

}
