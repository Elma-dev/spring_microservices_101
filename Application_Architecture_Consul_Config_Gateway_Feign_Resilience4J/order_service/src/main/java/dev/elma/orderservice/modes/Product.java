package dev.elma.orderservice.modes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Long Quantity;
}