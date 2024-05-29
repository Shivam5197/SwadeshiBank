package com.bank.SwadeshiBank.Services.Impl;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.Entity.Accounts;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Mapper.AccountsMapper;
import com.bank.SwadeshiBank.Repository.AccountsRepository;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;
import com.bank.SwadeshiBank.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.Services.AccountsService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountsServiceImpl implements AccountsService {


    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public AccountsDTO createAccount(Users users, AccountsDTO accountsDTO, List<String> errorList) {
        AccountsDTO newAccountDTO = new AccountsDTO();

        try {
            // Check if the user is not null and is active
            if (!Utils.isNull(users) && users.isActive()) {
                if (Utils.isNull(accountsDTO)) {
                    // Create a new account with default values
                    newAccountDTO.setAccountNumber(RandomStringGenerator.generateRandomNumeric(12));
                    newAccountDTO.setBranchPincode("201005");
                    newAccountDTO.setBranchState("Uttar Pradesh");
                    newAccountDTO.setBranchCity("Ghaziabad");
                    newAccountDTO.setAccountType(Constants.AccountType.SAVINGS_ACCOUNT);
                    newAccountDTO.setBranchAddress("C-1008 Kalash Homes");
                    newAccountDTO.setMinimumAmountRequired(1000);
                    newAccountDTO.setBalanceAmount(1000);
                } else {
                    // Set account number and map DTO to Accounts entity
                    accountsDTO.setAccountNumber(RandomStringGenerator.generateRandomNumeric(12));
                    Accounts accounts = AccountsMapper.mapToAccounts(accountsDTO, new Accounts());

                    // Save the account and map back to DTO
                    accounts = accountsRepository.save(accounts);
                    newAccountDTO = AccountsMapper.mapToAccountsDTO(accountsDTO, accounts);
                }
            }
        } catch (Exception e) {
            errorList.add("Something went wrong, please try again later.");
            e.printStackTrace();
        }
        return newAccountDTO;
    }


}
