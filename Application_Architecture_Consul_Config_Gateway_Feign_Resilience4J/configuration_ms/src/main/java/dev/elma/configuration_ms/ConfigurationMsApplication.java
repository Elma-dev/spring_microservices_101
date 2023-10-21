package dev.elma.configuration_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigurationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationMsApplication.class, args);
	}

}
