package com.bank.SwadeshiBank.Exceptions;

public class IncorrectUPIDetails extends  RuntimeException{

    public IncorrectUPIDetails(String message){
        super(message);
    }
}
