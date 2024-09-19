package com.asarit.flipkart.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String first_name;
    private String Last_name;
    private String email;
    private String phone_no;




}
