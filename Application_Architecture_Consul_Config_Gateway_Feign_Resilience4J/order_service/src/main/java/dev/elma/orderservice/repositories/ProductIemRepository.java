package dev.elma.orderservice.repositories;

import dev.elma.orderservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductIemRepository extends JpaRepository<ProductItem,Long> {
}
