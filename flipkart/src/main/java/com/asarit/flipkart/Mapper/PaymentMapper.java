package com.asarit.flipkart.Mapper;

import com.asarit.flipkart.Dtos.PaymentDto;
import com.asarit.flipkart.Models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentDto paymentDto){
        return new Payment(
                paymentDto.getPayment_date(),
                paymentDto.getPayment_method(),
                paymentDto.getAmount());
    }

}
