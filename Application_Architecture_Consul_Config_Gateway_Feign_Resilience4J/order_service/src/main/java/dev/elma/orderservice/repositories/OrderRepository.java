package dev.elma.orderservice.repositories;

import dev.elma.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllBycustomerId(Long customerId);
}
