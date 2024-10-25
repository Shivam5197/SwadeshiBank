package com.bank.SwadeshiBank.Services;

import com.bank.SwadeshiBank.DTO.TransactionsDTO;
import com.bank.SwadeshiBank.Entity.UPI_Entity;
import com.bank.SwadeshiBank.Exceptions.PaymentFailureException;

import java.util.List;

public interface TransactionService {

    boolean CreateTransactions(TransactionsDTO fromTransactionsDTO, TransactionsDTO toTransactionsDTO,List<String> errorList) throws PaymentFailureException;

}
