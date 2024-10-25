package com.bank.SwadeshiBank.Mapper;

import com.bank.SwadeshiBank.DTO.TransactionsDTO;
import com.bank.SwadeshiBank.Entity.Transactions;
import com.bank.SwadeshiBank.Utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionMapper {

    public static Transactions mapToTransactionsEntity(TransactionsDTO transactionsDTO, List<String> errorList){
            Transactions transactions = new Transactions();


        if(!Utils.isNull(transactionsDTO)){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date transactionTime = null;
        try {
            transactionTime = sdf.parse(transactionsDTO.getTransactionTime());
            transactions.setTransactionTime(transactionTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
                transactions.setTransactionType(transactionsDTO.getTransactionType());
                transactions.setAmount(transactionsDTO.getAmount());
                transactions.setBankName(transactionsDTO.getBankName());
                transactions.setDebitedOrCredited(transactionsDTO.getDebitedOrCredited());
                transactions.setTransactionType(transactionsDTO.getTransactionType());
                transactions.setFromAccountNumber(transactionsDTO.getFromAccountNumber());
                transactions.setToAccountNumber(transactionsDTO.getToAccountNumber());
                transactions.setNameInAccount(transactionsDTO.getNameInAccount());
                transactions.setFeeOrCharges(transactionsDTO.getFeeOrCharges());
                transactions.setIfscCode(transactionsDTO.getIfscCode());
                transactions.setTransactionStatus(transactionsDTO.getTransactionStatus());
            }else {
                errorList.add("No Data to Map ");
            }
            return transactions;
    }

    public static TransactionsDTO mapToTransactionsEntity(Transactions transactions, List<String> errorList){
        TransactionsDTO transactionsDTO = new TransactionsDTO();


        if(!Utils.isNull(transactions)){

            transactionsDTO.setTransactionTime(transactions.getTransactionTime().toString());
            transactionsDTO.setTransactionType(transactions.getTransactionType());
            transactionsDTO.setAmount(transactions.getAmount());
            transactionsDTO.setBankName(transactions.getBankName());
            transactionsDTO.setDebitedOrCredited(transactions.getDebitedOrCredited());
            transactionsDTO.setTransactionType(transactions.getTransactionType());
            transactionsDTO.setFromAccountNumber(transactions.getFromAccountNumber());
            transactionsDTO.setToAccountNumber(transactions.getToAccountNumber());
            transactionsDTO.setNameInAccount(transactions.getNameInAccount());
            transactionsDTO.setFeeOrCharges(transactions.getFeeOrCharges());
            transactionsDTO.setIfscCode(transactions.getIfscCode());
            transactionsDTO.setTransactionStatus(transactions.getTransactionStatus());
        }else {
            errorList.add("No Data to Map ");
        }
        return transactionsDTO;
    }

}
