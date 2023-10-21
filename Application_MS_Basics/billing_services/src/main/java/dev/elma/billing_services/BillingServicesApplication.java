package dev.elma.billing_services;

import dev.elma.billing_services.entities.Bill;
import dev.elma.billing_services.entities.ProductItem;
import dev.elma.billing_services.feignApi.CustomerRestClient;
import dev.elma.billing_services.feignApi.ProductRestClient;
import dev.elma.billing_services.models.Customer;
import dev.elma.billing_services.models.Product;
import dev.elma.billing_services.repositories.BillJpaRepository;
import dev.elma.billing_services.repositories.ProductItemJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
@EnableFeignClients
public class BillingServicesApplication implements CommandLineRunner {
    private BillJpaRepository billJpaRepository;
    private ProductItemJpaRepository productItemJpaRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;


    public static void main(String[] args) {
        SpringApplication.run(BillingServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<3;i++){
            Customer customer = customerRestClient.findCustomerById(i + 1L);
            Product product1 = productRestClient.findProductById(i + 1L);

            Bill bill = Bill.builder().BillingDate(new Date()).CustomerId(i+1L).customer(customer).build();
            ProductItem product = ProductItem.builder().productId(i + 1L).product(product1).price((i + 1) * 10D).quantity((i + 1) * 5).bill(bill).build();
            billJpaRepository.save(bill);
            productItemJpaRepository.save(product);
        }


    }
}
