package dev.elma.billing_services.repositories;

import dev.elma.billing_services.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemJpaRepository extends JpaRepository<ProductItem,Long> {
}
