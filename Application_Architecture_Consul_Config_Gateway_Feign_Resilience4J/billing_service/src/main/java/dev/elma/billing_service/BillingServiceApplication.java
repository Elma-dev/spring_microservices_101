package dev.elma.billing_service;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.core.VaultTemplate;

import java.util.Map;

@SpringBootApplication
@AllArgsConstructor
public class BillingServiceApplication implements CommandLineRunner {
    private VaultTemplate vaultTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        vaultTemplate.opsForVersionedKeyValue("secret").put(
                "myOtherSecrets", Map.of("dev","elmadev","sport","workHard")
        );
    }
}
