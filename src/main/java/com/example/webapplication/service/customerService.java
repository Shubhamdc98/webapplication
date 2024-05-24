package com.example.webapplication.service;

import com.example.webapplication.entity.Customer;
import com.example.webapplication.repository.customerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class customerService {

    private final customerRepository customRepo;

    public Customer postCustomer(Customer newCustomer) {
        return customRepo.save(newCustomer);
    }

    public List<Customer> getAllCustomer(){
        return customRepo.findAll();
    }

    public Customer findCustomerById(Long id) {
        return customRepo.findById(id).orElse(null);

    }

    public Customer updateCustomer(Long id, Customer newCust) {
        Customer existingCustomer = findCustomerById(id);
        if(existingCustomer == null)
            return null;
        existingCustomer.setName(newCust.getName());
        existingCustomer.setEmail(newCust.getEmail());
        existingCustomer.setPhone(newCust.getPhone());
        customRepo.save(existingCustomer);
        return existingCustomer;
    }

    public Customer deleteCustomer(Long id) {
        Customer existingCustomer = findCustomerById(id);
        if(existingCustomer == null) {
            return null;
        }else {
            customRepo.deleteById(id);
            return existingCustomer;
        }
    }





}
