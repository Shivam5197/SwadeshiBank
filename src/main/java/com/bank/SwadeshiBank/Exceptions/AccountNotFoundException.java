package com.bank.SwadeshiBank.Exceptions;

public class AccountNotFoundException extends RuntimeException{


    public AccountNotFoundException (String message){
        super(message);
    }
}
