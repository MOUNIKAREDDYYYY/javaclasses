package com.asarit.flipkart.Controller;

import com.asarit.flipkart.Dtos.CustomerDto;
import com.asarit.flipkart.Services.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/save")
    @Transactional
    public ResponseEntity<String> postCustomer(@RequestBody CustomerDto customerDto){
        customerService.addCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

    @GetMapping("/getAllCustomer")
    public List<CustomerDto> getAllCustomer(){
        return customerService.findAllCustomers();
    }

    @PutMapping("/{customerId}")
    public String updateCustomer(@PathVariable ("customerId") Long customerId, @RequestBody CustomerDto customerDto){
       customerService.updateCustomer(customerId,customerDto);
       return "success";

    }

    @DeleteMapping("/{customerId}")
    public String deleteById(@PathVariable ("customerId") Long customerId){
        customerService.deleteById(customerId);
        return "success";
    }

}
