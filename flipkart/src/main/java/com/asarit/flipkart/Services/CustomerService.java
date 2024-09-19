package com.asarit.flipkart.Services;

import com.asarit.flipkart.Dtos.CustomerDto;
import com.asarit.flipkart.Models.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(CustomerDto customerDto);

     List<CustomerDto> findAllCustomers();


    void updateCustomer(Long customerId, CustomerDto customerDto);


    void deleteById(Long customerId);


    Customer findById(Long customerId);
}


