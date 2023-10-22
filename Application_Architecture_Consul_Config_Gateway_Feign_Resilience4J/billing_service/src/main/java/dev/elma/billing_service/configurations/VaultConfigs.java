package dev.elma.billing_service.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("user")
@Data
public class VaultConfigs {
    private String username;
    private String password;

}
