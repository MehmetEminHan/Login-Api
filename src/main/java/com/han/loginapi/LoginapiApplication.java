package com.han.loginapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class LoginapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginapiApplication.class, args);


	}


}
