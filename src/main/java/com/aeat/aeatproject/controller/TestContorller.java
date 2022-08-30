package com.aeat.aeatproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestContorller {

    @GetMapping("/test/kakaosearchtest")
    public String test(){
        return "/test/kakaosearchtest";
    }
}
