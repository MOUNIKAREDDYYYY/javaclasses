package com.asarit.flipkart.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String payment_date;
    private String payment_method;
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customerId")
    private Customer customer;


    public Payment(String payment_date, String payment_method, Double amount) {
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.amount = amount;
    }
}
