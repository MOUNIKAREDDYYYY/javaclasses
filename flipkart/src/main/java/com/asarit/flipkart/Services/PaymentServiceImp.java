package com.asarit.flipkart.Services;
import com.asarit.flipkart.Dtos.PaymentDto;
import com.asarit.flipkart.Mapper.PaymentMapper;
import com.asarit.flipkart.Models.Customer;
import com.asarit.flipkart.Models.Payment;
import com.asarit.flipkart.Repo.PaymentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PaymentServiceImp implements PaymentService{

    private final PaymentRepo paymentRepo;
    private final CustomerService customerService;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImp(PaymentRepo paymentRepo, CustomerService customerService, PaymentMapper paymentMapper) {
        this.paymentRepo = paymentRepo;
        this.customerService = customerService;
        this.paymentMapper = paymentMapper;
    }


    @Override
    @Transactional
    public void addPayment(PaymentDto paymentDto) {
        Payment paymentFromDb = paymentMapper.toPayment(paymentDto);
        Customer customerFromDb = customerService.findById(paymentDto.getCustomer_id());
        paymentFromDb.setCustomer(customerFromDb);
        paymentRepo.save(paymentFromDb);


//        Payment payment=new Payment();
//        Customer customerFromDb = customerService.findById(paymentDto.getCustomer_id());
//        payment.setPayment_method(paymentDto.getPayment_method());
//        payment.setPayment_date(paymentDto.getPayment_date());
//        payment.setAmount(paymentDto.getAmount());
//        payment1.setCustomer(customerFromDb);
//        paymentRepo.save(payment);

    }

    @Override
    public List<PaymentDto> findAllPayments(){
        return paymentRepo.findAll().stream()
                .map(payment -> new PaymentDto(
                        payment.getId(),
                        payment.getCustomer().getId(),
                        payment.getPayment_date(),
                        payment.getPayment_method(),
                        payment.getAmount())).toList();
    }



}
