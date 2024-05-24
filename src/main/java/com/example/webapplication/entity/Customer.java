package com.example.webapplication.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String email;

    String phone;
}
