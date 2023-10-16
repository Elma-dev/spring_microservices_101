package dev.elma.inventory_microservices.repositories;

import dev.elma.inventory_microservices.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product,Long> {
}
