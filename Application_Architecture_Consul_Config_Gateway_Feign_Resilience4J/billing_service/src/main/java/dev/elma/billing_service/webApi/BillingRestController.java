package dev.elma.billing_service.webApi;

import dev.elma.billing_service.configurations.ConsulConfigs;
import dev.elma.billing_service.configurations.VaultConfigs;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class BillingRestController {
    private ConsulConfigs consulConfigs;
    private VaultConfigs vaultConfigs;

    @GetMapping("/configs")
    public Map<String,Object> getConsulConfigs(){
        return Map.of("consulConfigs",consulConfigs,"vaultConfigs",vaultConfigs);
    }

}
