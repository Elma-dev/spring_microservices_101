package dev.elma.billing_services.web;

import dev.elma.billing_services.entities.Bill;
import dev.elma.billing_services.feignApi.CustomerRestClient;
import dev.elma.billing_services.feignApi.ProductRestClient;
import dev.elma.billing_services.models.Customer;
import dev.elma.billing_services.models.Product;
import dev.elma.billing_services.repositories.BillJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bills")
@AllArgsConstructor
public class BillRestApi {
    private BillJpaRepository billJpaRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    @GetMapping("/all")
    List<Bill> allBills(){
        List<Bill> bills = billJpaRepository.findAll();
        bills.stream().forEach(b->{
            Long customerId = b.getCustomerId();
            b.getProductItems().stream().forEach(productItem -> {
                Long productId = productItem.getProductId();
                Product productById = productRestClient.findProductById(productId);
                System.out.println(productById);
                productItem.setProduct(productById);
            });
            Customer customer = customerRestClient.findCustomerById(customerId);
            System.out.println(customer);
            b.setCustomer(customer);
        });

        return bills;
    }
    @PostMapping("/save")
    Bill saveBill(@RequestBody Bill bill){
        return billJpaRepository.save(bill);
    }

    @GetMapping("/{id}")
    Bill findBillById(@PathVariable Long id){
        return billJpaRepository.findById(id).orElseThrow();
    }
}
