package com.bank.SwadeshiBank.Exceptions;

public class PaymentFailureException extends RuntimeException{

    public PaymentFailureException (String message){
        super(message);
    }
}
