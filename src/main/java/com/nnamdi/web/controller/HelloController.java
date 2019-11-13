package com.nnamdi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;

/**
 * InMemoryUserDetailsManager enables us to create, retrieve, modify and delete the UserDetails and passwordEncoder is an implementation of BCryptPasswordEncoder used to encode the password
 */


@RestController
public class HelloController {

    @Autowired
    public InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView welcomePage (Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message","This is the welcome page " + principal.getName());
        model.setViewName("hello");
        return model;
    }

    @GetMapping("/employee")
    public String welcomeEmployee() {
        return "Welcome Employee";
    }

    @GetMapping("/admin")
    public String welcomeManager() {
        return "Welcome Manager";
    }

    @GetMapping("/employee/{username}")
    public String checkIfUserExists(@PathVariable("username") String username) {
        boolean flag = inMemoryUserDetailsManager.userExists(username);
        if (flag) {
            return "\" "+ username + "\" exists in InMemoryUserDetailManager";
        } else{
            return "\" "+ username + "\" does not  exist in InMemoryUserDetailManager....Check it  up later";
        }
    }

    @GetMapping("/employee/create/{username}/{password}/{role}")
    public String createUser(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("role") String role) {
        ArrayList<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        grantedAuthoritiesList.add(new SimpleGrantedAuthority(role));
        inMemoryUserDetailsManager.createUser(new User(username,passwordEncoder.encode(password), grantedAuthoritiesList));
        return checkIfUserExists(username);
    }

    @GetMapping("/employee/update/{username}/{password}/{role}")
    public String updateUser (@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("role") String role) {
        ArrayList<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        grantedAuthoritiesList.add(new SimpleGrantedAuthority(role));
        inMemoryUserDetailsManager.updateUser(new User(username, passwordEncoder.encode(password), grantedAuthoritiesList));
        return checkIfUserExists(username);
    }


    @GetMapping("/employee/delete/{username}")
    public String deleteUser (@PathVariable("username") String username) {
        inMemoryUserDetailsManager.deleteUser(username);
        return checkIfUserExists(username);
    }


//
//    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
//    public ModelAndView adminPage() {
//        ModelAndView model = new ModelAndView();
//        model.addObject("id", "1");
//        model.addObject("title", "Spring Security Hello World");
//        model.addObject("message", "This is protected page");
//        model.setViewName("admin");
//        return model;
//    }
}

