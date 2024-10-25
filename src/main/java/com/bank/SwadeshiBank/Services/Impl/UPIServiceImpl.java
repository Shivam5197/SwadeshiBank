package com.bank.SwadeshiBank.Services.Impl;

import java.util.List;

import com.bank.SwadeshiBank.DTO.TransactionsDTO;
import com.bank.SwadeshiBank.Entity.Accounts;
import com.bank.SwadeshiBank.Exceptions.PaymentFailureException;
import com.bank.SwadeshiBank.Mapper.UPIMapper;
import com.bank.SwadeshiBank.Services.TransactionService;
import com.bank.SwadeshiBank.Utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.UPIDTO;
import com.bank.SwadeshiBank.Entity.UPI_Entity;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Exceptions.AccountNotFoundException;
import com.bank.SwadeshiBank.Exceptions.IncorrectUPIDetails;
import com.bank.SwadeshiBank.Mapper.AccountsMapper;
import com.bank.SwadeshiBank.Repository.UPIRepository;
import com.bank.SwadeshiBank.Repository.UsersRepository;
import com.bank.SwadeshiBank.Services.AccountsService;
import com.bank.SwadeshiBank.Services.UPIService;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UPIServiceImpl implements UPIService {
    /**
     * @param username
     * @param errorList
     * @return
     */
    private static final Logger log = LogManager.getLogger(UPIServiceImpl.class);

    @Autowired
    UPIRepository upiRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    AccountsService accountsService;

    @Autowired
    TransactionService transactionService;

    @Override
    public UPI_Entity generateUPIId(UPIDTO upidto , String username, Long accountNumber, List<String> errorList) {
    	boolean isUPICreated = false;
        UPI_Entity upiEntity = new UPI_Entity();
        try {
            if(!username.isEmpty() || accountNumber !=null){
            	AccountsDTO accountsDTO = accountsService.getAccountByAccountNumber(accountNumber,errorList);
                Users users = usersRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("Username not found !"));
                if(users !=null) {

                    upiEntity.setUpiId(users.getMobileNumber() + "@swd");
                    String upiPass = RandomStringGenerator.generateRandomNumeric(6).toString();
                    if(upidto == null || upidto.getUPI_CODE().isEmpty()) {
                        upiEntity.setUPI_CODE(new BCryptPasswordEncoder().encode(upiPass));
                    }else{
                        log.info("else");
                    	upiEntity.setUPI_CODE(new BCryptPasswordEncoder().encode(upidto.getUPI_CODE()));
                    }
                    upiEntity.setUser(users);
                    upiEntity.setAccount(AccountsMapper.mapToAccounts(accountsDTO));
                    upiEntity.setIfscCode(accountsDTO.getIfscCode());
                    upiEntity.setContactEmail(users.getEmail());
                    upiEntity.setContactNumber(users.getMobileNumber());
                    upiEntity.setStatus(Constants.status.ACTIVE);
                    log.info("upiEntity" + upiEntity);
                    upiRepository.save(upiEntity);
                    isUPICreated = true;
                    upiEntity.setUPI_CODE(upiPass);
                    upiEntity.setUpiId(upiEntity.getUpiId());
                }
            }else {
                throw new AccountNotFoundException("Username or Account Number is Incorrect ! ");

            }
        }catch (Exception e){
            throw new IncorrectUPIDetails("The details provided for the UPI are incorrect! ");
        }
        return upiEntity;
    }

    /**
     * @param fromUpiId
     * @param ToUpiId
     * @param errorList
     * @return
     * @throws PaymentFailureException
     */
    @Override
    public boolean makeUPIPayment(String fromUpiId,String fromUPICode, long paymentAmount, String ToUpiId, List<String> errorList) throws PaymentFailureException {

        UPI_Entity fromUpiEntity = new UPI_Entity();
        UPI_Entity toUpiEntity = new UPI_Entity();
        boolean isCreated = false;
        if(!Utils.isNull(fromUpiId)){
            fromUpiEntity = upiRepository.findByUpiId(fromUpiId).orElseThrow(()-> new IncorrectUPIDetails("Incorrect UPI Id"));

            toUpiEntity = upiRepository.findByUpiId(ToUpiId).orElseThrow(()-> new IncorrectUPIDetails("Incorrect UPI Id"));

            if(fromUpiEntity.getUpiId() !=null || toUpiEntity.getUpiId() != null ){

                //Take money from one account

           Accounts senderAccountDetails  =  fromUpiEntity.getAccount();
           Accounts receiverAccountsDetails = toUpiEntity.getAccount();

           //Password check before making the payment
           if(fromUPICode !=null && new BCryptPasswordEncoder().matches(fromUPICode, fromUpiEntity.getUPI_CODE())){
               TransactionsDTO fromTransactionsDTO = new TransactionsDTO();


               //Sender Transaction Data
               fromTransactionsDTO.setToAccountNumber(toUpiEntity.getAccount().getAccountNumber());
               fromTransactionsDTO.setDebitedOrCredited(Constants.transactionType.DEBITED);
               fromTransactionsDTO.setAmount(paymentAmount);
               fromTransactionsDTO.setFromAccountNumber(fromUpiEntity.getAccount().getAccountNumber());
               fromTransactionsDTO.setNameInAccount(toUpiEntity.getUser().getFullname());
               //transactionsDTO.setTransactionTime();
               fromTransactionsDTO.setBankName("Swadeshi Bank");//currently its just swadeshi Bank
               fromTransactionsDTO.setIfscCode(toUpiEntity.getIfscCode());
               fromTransactionsDTO.setTransactionType(Constants.transactionMethod.UPI);

               //Receiver Transaction Data
               TransactionsDTO toTransactionsDTO = new TransactionsDTO();
               toTransactionsDTO.setToAccountNumber(toUpiEntity.getAccount().getAccountNumber());
               toTransactionsDTO.setDebitedOrCredited(Constants.transactionType.CREDITED);
               toTransactionsDTO.setAmount(paymentAmount);
               toTransactionsDTO.setFromAccountNumber(fromUpiEntity.getAccount().getAccountNumber());
               toTransactionsDTO.setNameInAccount(fromUpiEntity.getUser().getFullname());
               //transactionsDTO.setTransactionTime();
               toTransactionsDTO.setBankName("Swadeshi Bank");//currently its just swadeshi Bank
               toTransactionsDTO.setIfscCode(fromUpiEntity.getIfscCode());
               toTransactionsDTO.setTransactionType(Constants.transactionMethod.UPI);

               isCreated = transactionService.CreateTransactions(fromTransactionsDTO,toTransactionsDTO,errorList);

                  }
            }
        }
        return isCreated;
    }



}
