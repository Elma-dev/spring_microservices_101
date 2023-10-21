package dev.elma.orderservice.services;

import dev.elma.orderservice.modes.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/inventories/{id}?projection=fullInventory")
    public Product getProductById(@PathVariable Long id);
    @GetMapping("/inventories?projection=fullInventory")
    public PagedModel<Product> getAllProducts();
}
