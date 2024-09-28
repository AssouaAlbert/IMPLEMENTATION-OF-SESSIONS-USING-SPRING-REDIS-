package com.aassoua.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Return the name of the view that will be displayed for a 404 error
        return "error404"; // Name of the 404 error page (Thymeleaf or JSP view)
    }
}