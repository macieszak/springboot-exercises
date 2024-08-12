package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    // need a controller method to process the HTML form
    public String processForm() {
        return "helloworld";
    }

    @PostMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {

        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();
        String result = "Yo! " + theName;
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,
                                          Model model) {

        theName = theName.toUpperCase();
        String result = "Hey! " + theName;
        model.addAttribute("message", result);

        return "helloworld";
    }

}
