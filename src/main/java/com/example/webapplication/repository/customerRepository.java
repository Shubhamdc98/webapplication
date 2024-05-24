package com.example.webapplication.repository;

import com.example.webapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<Customer, Long> {

}
