package dev.elma.billing_service.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
@Data
public class ConsulConfigs {
    private String accessTokenTimeout;
    private String refreshTokenTimeout;
}
