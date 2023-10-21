package dev.elma.inventory_service;

import dev.elma.inventory_service.entities.Inventory;
import dev.elma.inventory_service.repositories.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class InventoryServiceApplication implements CommandLineRunner {

	private InventoryRepository inventoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inventoryRepository.saveAll(
			List.of("Mac m1","Mac m2","Lenovo 670","Dell Rouge").stream().map(n->{
					return Inventory.builder().name(n).price(n.length()*100D).quantity(n.length()*10L).build();
				}).toList()
		);
		inventoryRepository.findAll().forEach(System.out::println);
	}
}
