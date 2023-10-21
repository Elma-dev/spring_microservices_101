package dev.elma.orderservice.webApi;

import dev.elma.orderservice.entities.Order;
import dev.elma.orderservice.entities.ProductItem;
import dev.elma.orderservice.modes.Customer;
import dev.elma.orderservice.modes.Product;
import dev.elma.orderservice.repositories.OrderRepository;
import dev.elma.orderservice.repositories.ProductItemRepository;
import dev.elma.orderservice.services.CustomerRestClient;
import dev.elma.orderservice.services.ProductRestClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;
    @GetMapping("/all")
    public List<Order> getAllOrders(){
        List<Order> all = orderRepository.findAll();
        all.stream().forEach(
                o->{
                    Customer customer = customerRestClient.getCustomersById(o.getCustomerId());
                    o.setCustomer(customer);
                    o.getProductItems().forEach(productItem -> {
                        Product product = productRestClient.getProductById(productItem.getProductId());
                        productItem.setProduct(product);
                    });
                }
        );
        return all;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        Long customerId = order.getCustomerId();
        Customer customer = customerRestClient.getCustomersById(customerId);
        order.setCustomer(customer);
        order.getProductItems().forEach(productItem -> {
            Product product = productRestClient.getProductById(productItem.getProductId());
            productItem.setProduct(product);
        });
        return order;
    }
}
