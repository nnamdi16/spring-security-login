package com.nnamdi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HelloController {
    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView welcomePage (Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message","This is the welcome page" + principal.getName());
        model.setViewName("hello");
        return model;
    }


    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("id", "1");
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page");
        model.setViewName("admin");
        return model;
    }
}
