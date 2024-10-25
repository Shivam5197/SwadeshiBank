package com.bank.SwadeshiBank.Exceptions.handler;

import com.bank.SwadeshiBank.Exceptions.PaymentFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bank.SwadeshiBank.Exceptions.AccountNotFoundException;
import com.bank.SwadeshiBank.Exceptions.IncorrectUPIDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException ex){

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectUPIDetails.class)
    public ResponseEntity<ErrorResponse> handleIncorrectUPIDetails(IncorrectUPIDetails e){

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(),e.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(PaymentFailureException.class)
    public ResponseEntity<ErrorResponse> handlePaymentFailureException(PaymentFailureException e){

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(),e.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.FORBIDDEN);
    }

}
