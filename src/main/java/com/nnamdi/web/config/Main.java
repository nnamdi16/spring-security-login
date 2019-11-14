package com.nnamdi.web.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("pass");
        System.out.println(password);
    }
}


//$2a$10$ef4UbtkMA8tTUxkOGPe5EeAirs/ZgoldbkE7QJPddd80pA.JP7fTq