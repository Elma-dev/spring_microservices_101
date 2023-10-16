package dev.elma.billing_services;

import dev.elma.billing_services.entities.Bill;
import dev.elma.billing_services.entities.ProductItem;
import dev.elma.billing_services.repositories.BillJpaRepository;
import dev.elma.billing_services.repositories.ProductItemJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class BillingServicesApplication implements CommandLineRunner {
    private BillJpaRepository billJpaRepository;
    private ProductItemJpaRepository productItemJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(BillingServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<5;i++){
            Bill bill = Bill.builder().BillingDate(new Date()).CustomerId(1L).build();
            ProductItem product = ProductItem.builder().productId(i + 1L).price((i + 1) * 10D).quantity((i + 1) * 5).bill(bill).build();
            billJpaRepository.save(bill);
            productItemJpaRepository.save(product);
        }


    }
}
