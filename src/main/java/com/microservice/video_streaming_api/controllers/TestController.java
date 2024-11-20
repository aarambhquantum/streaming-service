package com.microservice.video_streaming_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testController")
public class TestController {
    @GetMapping("/test")
    public String test() {
        //todo remove it
        return "This is a test endpoint, getting tested!";
    }
    
}
