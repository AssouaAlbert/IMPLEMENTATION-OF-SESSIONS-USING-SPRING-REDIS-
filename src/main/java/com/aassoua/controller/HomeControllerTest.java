package com.aassoua.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerTest {

    @GetMapping("/custom-login")
    public String login() {
        return "login";  // Renders login.html
    }

    @GetMapping("/homes")
    public String home() {
        return "home";  // Renders home.html
    }
}