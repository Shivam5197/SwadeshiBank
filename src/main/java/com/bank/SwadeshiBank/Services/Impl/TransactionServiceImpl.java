package com.bank.SwadeshiBank.Services.Impl;

import com.bank.SwadeshiBank.DTO.TransactionsDTO;
import com.bank.SwadeshiBank.Entity.Transactions;
import com.bank.SwadeshiBank.Entity.UPI_Entity;
import com.bank.SwadeshiBank.Exceptions.PaymentFailureException;
import com.bank.SwadeshiBank.Mapper.TransactionMapper;
import com.bank.SwadeshiBank.Repository.TransactionRepository;
import com.bank.SwadeshiBank.Services.TransactionService;
import com.bank.SwadeshiBank.Utils.Utils;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {


    private static final Logger log = LogManager.getLogger(TransactionServiceImpl.class);

    @Autowired
    TransactionRepository transactionRepository;

    /**
     * @param fromTransactionsDTO
     * @param toTransactionsDTO
     * @param errorList
     * @return
     * @throws PaymentFailureException
     */
    @Override
    public boolean CreateTransactions(TransactionsDTO fromTransactionsDTO,TransactionsDTO toTransactionsDTO ,List<String> errorList) throws PaymentFailureException {
        boolean isCreated = false;
        Transactions fromTransactions = new Transactions();
        Transactions toTransactions = new Transactions();

        try {
            if(!Utils.isNull(fromTransactionsDTO) && !Utils.isNull(toTransactionsDTO))    {
                fromTransactions =   TransactionMapper.mapToTransactionsEntity(fromTransactionsDTO,errorList);

                toTransactions =   TransactionMapper.mapToTransactionsEntity(toTransactionsDTO,errorList);

             if(!Utils.isNull(errorList)){
                 transactionRepository.save(fromTransactions);
                 transactionRepository.save(toTransactions);
                 isCreated = true;
             }
                    }
        } catch (Exception e) {
            errorList.add("Payment Failure we are sorry we are not able to process this payment! It's not you it's us! We have raised a ticket to concern team " +
                    "to get this resolved! Please try again later! ");
            throw new PaymentFailureException("Payment Failure");
        }
        return isCreated;
    }
}
