package dev.elma.billing_services.feignApi;

import dev.elma.billing_services.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PRODUCT-SERVICES")
public interface ProductRestClient {
    @GetMapping("/products/all")
    PagedModel<Product> getAllProds();
    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable(name="id") Long id);
}
