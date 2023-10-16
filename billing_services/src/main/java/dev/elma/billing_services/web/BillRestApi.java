package dev.elma.billing_services.web;

import dev.elma.billing_services.entities.Bill;
import dev.elma.billing_services.repositories.BillJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bills")
@AllArgsConstructor
public class BillRestApi {
    private BillJpaRepository billJpaRepository;
    @GetMapping("/all")
    List<Bill> allBills(){
        return billJpaRepository.findAll();
    }
    @PostMapping("/save")
    Bill saveBill(@RequestBody Bill bill){
        return billJpaRepository.save(bill);
    }

    @GetMapping("/{id}")
    Bill findBillById(@PathVariable Long id){
        return billJpaRepository.findById(id).orElseThrow();
    }
}
