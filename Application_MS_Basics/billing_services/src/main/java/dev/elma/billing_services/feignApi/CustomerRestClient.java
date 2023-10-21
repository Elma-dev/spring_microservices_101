package dev.elma.billing_services.feignApi;

import dev.elma.billing_services.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICES")
public interface CustomerRestClient {
    @GetMapping("/customers/all")
    PagedModel<Customer> customerPage();
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable(name="id") Long id);
}
