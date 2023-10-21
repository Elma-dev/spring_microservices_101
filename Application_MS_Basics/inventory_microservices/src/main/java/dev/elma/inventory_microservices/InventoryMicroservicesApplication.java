package dev.elma.inventory_microservices;

import dev.elma.inventory_microservices.entities.Product;
import dev.elma.inventory_microservices.repositories.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
public class InventoryMicroservicesApplication implements CommandLineRunner {
	private ProductJpaRepository productJpaRepository;
	public static void main(String[] args) {
		SpringApplication.run(InventoryMicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("TED","Candy","Cola").forEach(
				p->{
					Product product = Product.builder().name(p).price(p.length() * 100D).build();
					productJpaRepository.save(product);
				}
		);
	}
}
