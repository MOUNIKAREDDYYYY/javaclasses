package com.asarit.flipkart.Controller;


import com.asarit.flipkart.Dtos.CustomerDto;
import com.asarit.flipkart.Dtos.PaymentDto;

import com.asarit.flipkart.Models.Payment;
import com.asarit.flipkart.Services.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
   private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/save")
    @Transactional
    public String postPayment(@RequestBody PaymentDto paymentDto){
        paymentService.addPayment(paymentDto);
        return "success";
    }

    @GetMapping("/getAllPayment")
    public List<PaymentDto>getAllPayment(){
        return paymentService.findAllPayments();
    }


}
