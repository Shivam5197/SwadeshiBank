package com.bank.SwadeshiBank.Services;

import java.util.List;

import com.bank.SwadeshiBank.DTO.UPIDTO;
import com.bank.SwadeshiBank.Entity.UPI_Entity;
import com.bank.SwadeshiBank.Exceptions.PaymentFailureException;

public interface UPIService {

    UPI_Entity generateUPIId(UPIDTO upidto , String username, Long accountNumber, List<String> errorList);
    boolean makeUPIPayment(String fromUpiId,String fromUPICode,long paymentAmount,String ToUpiId, List<String> errorList) throws PaymentFailureException;

}
