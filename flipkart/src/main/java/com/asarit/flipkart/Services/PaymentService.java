package com.asarit.flipkart.Services;

import com.asarit.flipkart.Dtos.PaymentDto;

import java.util.List;

public interface PaymentService {


      List<PaymentDto> findAllPayments();

      void addPayment(PaymentDto paymentDto);


}
