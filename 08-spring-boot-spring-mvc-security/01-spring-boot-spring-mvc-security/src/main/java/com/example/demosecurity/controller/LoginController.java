package com.example.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "fancy-login";
    }

    @GetMapping("/leaders")
    public String showLeaders() {

        return "leaders";
    }

    // add request mapping for /systems

    @GetMapping("/systems")
    public String showSystems() {

        return "systems";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }

}
