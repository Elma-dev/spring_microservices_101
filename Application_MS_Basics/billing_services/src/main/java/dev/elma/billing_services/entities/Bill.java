package dev.elma.billing_services.entities;


import dev.elma.billing_services.models.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date BillingDate;
    private Long CustomerId;
    @OneToMany(mappedBy ="bill")
    private Collection<ProductItem> productItems;
    @Transient
    private Customer customer;

}
