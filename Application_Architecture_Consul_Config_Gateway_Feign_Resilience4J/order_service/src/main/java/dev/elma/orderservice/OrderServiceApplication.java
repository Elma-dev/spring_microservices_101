package dev.elma.orderservice;

import dev.elma.orderservice.entities.Order;
import dev.elma.orderservice.entities.ProductItem;
import dev.elma.orderservice.enums.OrderStatus;
import dev.elma.orderservice.modes.Customer;
import dev.elma.orderservice.modes.Product;
import dev.elma.orderservice.repositories.OrderRepository;
import dev.elma.orderservice.repositories.ProductItemRepository;
import dev.elma.orderservice.services.CustomerRestClient;
import dev.elma.orderservice.services.ProductRestClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@AllArgsConstructor
@EnableFeignClients
public class OrderServiceApplication implements CommandLineRunner {
	private OrderRepository orderRepository;
	private ProductItemRepository productIemRepository;
	private CustomerRestClient customerRestClient;
	private ProductRestClient productRestClient;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Customer> allCustomers = customerRestClient.getAllCustomers().getContent().stream().toList();
		List<Product> allProducts = productRestClient.getAllProducts().getContent().stream().toList();
		System.out.println(allProducts);
		System.out.println(allCustomers);
		
		Random random = new Random();
		for(int i=0;i<4;i++){
			Customer customer = allCustomers.get(random.nextInt(allCustomers.size()));
			Order order = orderRepository.save(
					Order.builder().
							orderDate(new Date()).
							customerId(customer.getId()).
							customer(customer).
							status(Math.random()>0.5?OrderStatus.DELIVERED:OrderStatus.CANCELED).
							build()
			);
			for (int j = 0; j < 10; j++) {
				if(Math.random()>0.7) {
					Product product = allProducts.get(random.nextInt(allProducts.size()));
					ProductItem productItem = productIemRepository.save(
							ProductItem.builder().
									productId(product.getId()).
									product(product).
									discount(Math.random()).
									price(1 + random.nextDouble(100)).
									order(order).
									build()
					);;
				}

			}
			System.out.println(order);                
		}



	}
}
