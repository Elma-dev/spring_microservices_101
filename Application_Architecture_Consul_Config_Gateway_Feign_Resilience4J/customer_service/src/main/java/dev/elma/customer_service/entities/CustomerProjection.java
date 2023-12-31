package dev.elma.customer_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Customer.class,name = "fullCustomer")
public interface CustomerProjection {
    public Long getId();
    public String getName();
    public String getEmail();
}
