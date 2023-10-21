package dev.elma.customerservices;

import dev.elma.customerservices.entities.Customer;
import dev.elma.customerservices.repositories.CustomerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
public class CustomerServicesApplication implements CommandLineRunner {
    CustomerJpaRepository customerJpaRepository;
    public static void main(String[] args) {
        SpringApplication.run(CustomerServicesApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Stream.of("Abdeljalil","Ayoub","Hicham").forEach(
                name->{
                    Customer c=Customer.builder().name(name).email(name+"@gmail.com").build();
                    customerJpaRepository.save(c);
                }
        );
    }
}
