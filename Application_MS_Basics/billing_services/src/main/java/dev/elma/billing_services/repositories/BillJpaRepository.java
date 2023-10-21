package dev.elma.billing_services.repositories;

import dev.elma.billing_services.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillJpaRepository extends JpaRepository<Bill,Long> {
}
