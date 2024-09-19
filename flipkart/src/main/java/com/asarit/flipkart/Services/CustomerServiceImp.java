package com.asarit.flipkart.Services;

import com.asarit.flipkart.Dtos.CustomerDto;

import com.asarit.flipkart.Exception.CustomerNotFoundException;

import com.asarit.flipkart.Models.Customer;
import com.asarit.flipkart.Models.Payment;
import com.asarit.flipkart.Repo.CustomerRepo;
import com.asarit.flipkart.Repo.PaymentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{

   private final CustomerRepo customerRepo;

    public CustomerServiceImp(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;

    }


    @Override
    public void addCustomer(CustomerDto customerDto) {
        Customer customer=new Customer();
        customer.setFirst_name(customerDto.getFirst_name());
        customer.setLast_name(customerDto.getLast_name());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone_no(customerDto.getPhone_no());
        customerRepo.save(customer);

    }

    @Override
    public List<CustomerDto> findAllCustomers() { 
       List<Customer> all= customerRepo.findAll();
       List<CustomerDto> customerDtos=new ArrayList<>();
       for(Customer customer:all){
           CustomerDto customerDto=new CustomerDto();
           customerDto.setId(customer.getId());
           customerDto.setFirst_name(customer.getFirst_name());
           customerDto.setLast_name(customer.getLast_name());
           customerDto.setPhone_no(customer.getPhone_no());
           customerDto.setEmail(customer.getEmail());
       }
        return  customerDtos;

    }

    @Override
    public void updateCustomer(Long customerId, CustomerDto customerDto) {
        Optional<Customer> byId = customerRepo.findById(customerId);
        if(byId.isEmpty()){
            throw new CustomerNotFoundException("product with this id" + customerId + "not found");
        }
        Customer customerFromDb = byId.get();
        customerFromDb.setPhone_no(customerDto.getPhone_no());
        customerFromDb.setFirst_name(customerDto.getFirst_name());
        customerFromDb.setLast_name(customerDto.getLast_name());
        customerFromDb.setEmail(customerDto.getEmail());
        customerRepo.save(customerFromDb);
    }

    @Override
    public void deleteById(Long customerId) {
        customerRepo.deleteById(customerId);
    }



    @Override
    public Customer findById(Long customerId) {
        Optional<Customer> byId = customerRepo.findById(customerId);
        return byId.get();
    }

}


