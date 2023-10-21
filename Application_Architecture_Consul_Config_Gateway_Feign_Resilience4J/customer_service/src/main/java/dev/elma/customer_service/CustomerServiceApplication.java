package dev.elma.customer_service;

import dev.elma.customer_service.entities.Customer;
import dev.elma.customer_service.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class CustomerServiceApplication implements CommandLineRunner {

    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        customerRepository.saveAll(List.of("abdeljalil","ahmed","ayoub").stream().map(
                n->{
                    return Customer.builder().name(n).email(n+"@gmail.com").build();
                }).toList());
        customerRepository.findAll().forEach(System.out::println);

    }
}
