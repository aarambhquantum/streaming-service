package com.microservice.video_streaming_api.services;

import com.microservice.video_streaming_api.configurations.SecretValueHolder;

public interface SecretService {
    // Secret Service to get critical data
    SecretValueHolder secretValueHolder();
}
