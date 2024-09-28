package com.aassoua.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error-page")
public class ErrorController {

    @GetMapping
    public String handleError() {
        // Return the name of the view that will be displayed for a 404 error
        return "error404"; // Name of the 404 error page (Thymeleaf or JSP view)
    }
}