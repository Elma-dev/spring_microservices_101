package dev.elma.inventory_service.repositories;

import dev.elma.inventory_service.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
