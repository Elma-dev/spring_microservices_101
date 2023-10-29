package dev.elma.orderservice.services;

import dev.elma.orderservice.entities.Order;
import dev.elma.orderservice.entities.ProductItem;
import dev.elma.orderservice.enums.OrderStatus;
import dev.elma.orderservice.modes.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "fullOrder",types = Order.class)
public interface OrderProjection {
    public Long getId();
    public Date getOrderDate();
    public OrderStatus getStatus();
    public Long getCustomerId();
    public Collection<ProductItem> getProductItems();
    public Customer getCustomer();



}
