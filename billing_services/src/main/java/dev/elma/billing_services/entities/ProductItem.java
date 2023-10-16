package dev.elma.billing_services.entities;

import dev.elma.billing_services.models.Customer;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor

@Data

public class ProductItem {
    private Long id;
    private Date BillingDate;
    private Long CustomerId;
    @Transient
    private Customer customer;

}
