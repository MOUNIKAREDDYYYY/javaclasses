package com.asarit.flipkart.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String Last_name;
    private String email;
    private String password;
    private Long address;
    private String phone_no;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Payment> payments;
}
