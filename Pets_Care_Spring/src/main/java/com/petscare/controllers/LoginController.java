package com.petscare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {


    @GetMapping("/login")
    public String log() {
        return "login/login";
    }

    @GetMapping("/access-denied")
    public String access() {
		return "login/access-denied";
	}
    
    
}