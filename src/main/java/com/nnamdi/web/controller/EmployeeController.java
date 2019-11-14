package com.nnamdi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

public class EmployeeController {

    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public String showUser() {
        return "Welcome User !!!!";
    }

    @GetMapping("/employee")
    public String showManager() {
        return "Welcome Employee !!!";
    }

    @GetMapping("/user/{username}")
    public String checkIfUserExists(@PathVariable("username") String username) {
        boolean flag = jdbcUserDetailsManager.userExists(username);
        if (flag) {
            return "\""+username + "\" exist in the Database";
        } else {
            return "\""+username + "\" deos not exist in the Database";
        }
    }

    @PostMapping("/user/{username}/{password}/{role}")
    public String createUser(@PathVariable("username") String username, @PathVariable("password")String password, @PathVariable("role") String role) {
        jdbcUserDetailsManager.createUser(User.withUsername(username).password(passwordEncoder.encode(password)).roles("USER").build());
        return checkIfUserExists(username);
    }

    @PutMapping("/user/{username}/{password}/{role}")
    public String updateUser(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("role") String role) {
        jdbcUserDetailsManager.updateUser(User.withUsername(username).password(passwordEncoder.encode(password)).roles("USER").build());
        return checkIfUserExists(username);
    }

    @DeleteMapping("user/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        jdbcUserDetailsManager.deleteUser(username);
        return checkIfUserExists(username);
    }

}
