package com.aeat.aeatproject.controller;

import com.aeat.aeatproject.domain.KakaoSearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestContorller {

    @GetMapping("/test/kakaosearchtest")
    public String test(){
        return "/test/kakaosearchtest";
    }

}
