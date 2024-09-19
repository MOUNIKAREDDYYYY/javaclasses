package com.asarit.flipkart.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private Long customer_id;
    private String payment_date;
    private String payment_method;
    private Double amount;


}
