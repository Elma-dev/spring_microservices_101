package dev.elma.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.elma.orderservice.enums.OrderStatus;
import dev.elma.orderservice.modes.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "Orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    private OrderStatus status;
    private Long customerId;
    @OneToMany(mappedBy = "order")
    private Collection<ProductItem> productItems;
    @Transient
    private Customer customer;
}
