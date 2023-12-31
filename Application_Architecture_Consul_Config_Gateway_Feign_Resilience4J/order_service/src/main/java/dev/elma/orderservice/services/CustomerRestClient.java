package dev.elma.orderservice.services;

import dev.elma.orderservice.modes.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}?projection=fullCustomer")
    public Customer getCustomersById(@PathVariable Long id);
    @GetMapping("/customers?projection=fullCustomer")
    public PagedModel<Customer> getAllCustomers();
}
