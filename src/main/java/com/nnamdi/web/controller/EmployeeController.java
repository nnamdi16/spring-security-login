package com.nnamdi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
//
//    @Autowired
//    JdbcUserDetailsManager jdbcUserDetailsManager;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;

    @GetMapping("/employee")
    public String showUser() {
        return "Welcome Employee !!!!";
    }

    @GetMapping("/manager")
    public String showManager() {
        return "Welcome Manager !!!";
    }

//    @GetMapping("/user/{username}")
//    public String checkIfUserExists(@PathVariable("username") String username) {
//        boolean flag = jdbcUserDetailsManager.userExists(username);
//        if (flag) {
//            System.out.println(" This is the true ");
//            return "\""+username + "\" exist in the Database";
//        } else {
//            System.out.println("This is not true");
//            return "\""+username + "\" does not exist in the Database";
//        }
//    }
//
//    @PostMapping("/user/{username}/{password}/{role}")
//    public String createUser(@PathVariable("username") String username, @PathVariable("password")String password, @PathVariable("role") String role) {
//        jdbcUserDetailsManager.createUser(User.withUsername(username).password(passwordEncoder.encode(password)).roles("USER").build());
//        return checkIfUserExists(username);
//    }
//
//    @PutMapping("/user/{username}/{password}/{role}")
//    public String updateUser(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("role") String role) {
//        jdbcUserDetailsManager.updateUser(User.withUsername(username).password(passwordEncoder.encode(password)).roles("USER").build());
//        return checkIfUserExists(username);
//    }
//
//    @DeleteMapping("user/{username}")
//    public String deleteUser(@PathVariable("username") String username) {
//        jdbcUserDetailsManager.deleteUser(username);
//        return checkIfUserExists(username);
//    }

    /**
     * JdbcUserDetailsManager and PasswordEncoder classes are autowired.
     * JdbcUserDetailsManager enables us to create, retrieve, modify nad delete the UserDetails
     * PasswordEncoder is an implementation of BCryptPasswordEncoder which is used to encode the password.
     * All request which start with /employee requires USER role and the request which starts with /manager requires MANAGER role.
     * CheckIfUserExist(), createUser(), updateUser(), deleteUser() methods helps us to make changes to the UserDetails persisted in the database.
     */

}
