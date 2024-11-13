package com.microservice.video_streaming_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

@SpringBootApplication
public class VideoStreamingApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoStreamingApiApplication.class, args);
    }
}