package dev.elma.customerservices.repositories;

import dev.elma.customerservices.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer,Long> {
}
