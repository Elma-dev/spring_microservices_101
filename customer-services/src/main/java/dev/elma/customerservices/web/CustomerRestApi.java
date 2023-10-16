package dev.elma.customerservices.web;

import dev.elma.customerservices.entities.Customer;
import dev.elma.customerservices.repositories.CustomerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerRestApi {
    private CustomerJpaRepository customerJpaRepository;

    @GetMapping("/all")
    List<Customer> allCustomers(){
        return customerJpaRepository.findAll();
    }
    @GetMapping("/{id}")
    Customer getCustomerByID(@PathVariable(name = "id") Long id){
        return customerJpaRepository.findById(id).get();
    }
    @PostMapping("/save")
    Customer saveCustomer(@RequestBody Customer customer){
        customerJpaRepository.save(customer);
        return customer;
    }
    @DeleteMapping("/delete/{id}")
    Customer deleteCustomer(@PathVariable Long id){
        Customer c = customerJpaRepository.findById(id).get();
        customerJpaRepository.delete(c);
        return c;
    }
    @PutMapping("/update/{id}")
    Customer updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
        Customer customer1 = customerJpaRepository.findById(id).orElseThrow();
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        return customerJpaRepository.save(customer1);
    }
}
