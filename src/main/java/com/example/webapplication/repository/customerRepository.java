package com.example.webapplication.repository;

import com.example.webapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<Customer, Long> {

}
