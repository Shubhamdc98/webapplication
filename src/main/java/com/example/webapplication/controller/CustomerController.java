package com.example.webapplication.controller;

import com.example.webapplication.entity.Customer;
import com.example.webapplication.repository.customerRepository;
import com.example.webapplication.service.customerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {

    private final customerRepository customRepo;

    private final customerService customService;

    @PostMapping("/customer")
    private ResponseEntity<Customer> postCustomer(@RequestBody Customer cust){
        Customer ExistingCustomer = customService.postCustomer(cust);
        if(ExistingCustomer == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(cust);
        }
    }

    @GetMapping("/AllCustomer")
    private ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> allCustomer = customService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }

    @GetMapping("/customer/{id}")
    private ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer cust = customService.findCustomerById(id);
        if(cust == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cust);
    }



    @PutMapping("/updateCustomer/{id}")
    private ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer custo){
        Customer cust = customService.updateCustomer(id, custo);
        if(cust == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cust);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    private ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Customer cust = customService.deleteCustomer(id);
        if(cust == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(cust);
        }
    }

}
