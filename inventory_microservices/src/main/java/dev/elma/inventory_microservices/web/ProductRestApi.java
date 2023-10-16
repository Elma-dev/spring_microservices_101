package dev.elma.inventory_microservices.web;

import dev.elma.inventory_microservices.entities.Product;
import dev.elma.inventory_microservices.repositories.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductRestApi {
    private ProductJpaRepository productJpaRepository;
    @GetMapping("/all")
    public List<Product> allProducts(){
        return productJpaRepository.findAll();
    }
}
