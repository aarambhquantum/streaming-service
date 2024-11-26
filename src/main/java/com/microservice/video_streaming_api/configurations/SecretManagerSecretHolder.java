package com.microservice.video_streaming_api.configurations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("secret-manager")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SecretManagerSecretHolder {
    // due to limiting cost involved in personal development, creating 1 secret
    private String allSecretHolder;
    private String runningEnvironment;
}
