package com.doctorsarl.doctorsarl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/test")
    public String showHomePge() {
        return "about";
    }
}
