package dev.elma.inventory_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Inventory.class,name = "fullInventory")
public interface InventoryProjection {
    public Long getId();
    public String getName();
    public String getPrice();
    public Long getQuantity();
}
