package com.bank.SwadeshiBank.Mapper;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.Entity.Accounts;

public class AccountsMapper {

    public static AccountsDTO mapToAccountsDTO(AccountsDTO accountsDTO, Accounts accounts){

        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setAccountType(accounts.getAccountType());
        accountsDTO.setBalanceAmount(accounts.getBalanceAmount());
        accountsDTO.setBranchCity(accounts.getBranchCity());
        accountsDTO.setBranchAddress(accounts.getBranchAddress());
        accountsDTO.setMinimumAmountRequired(accounts.getMinimumAmountRequired());
        accountsDTO.setBranchState(accounts.getBranchState());
        accountsDTO.setBranchPincode(accounts.getBranchPincode());

        return  accountsDTO;
    }


    public static Accounts mapToAccounts(AccountsDTO accountsDTO, Accounts accounts){

        accounts.setAccountNumber(accountsDTO.getAccountNumber());
        accounts.setAccountType(accountsDTO.getAccountType());
        accounts.setBalanceAmount(accountsDTO.getBalanceAmount());
        accounts.setBranchCity(accountsDTO.getBranchCity());
        accounts.setBranchAddress(accountsDTO.getBranchAddress());
        accounts.setMinimumAmountRequired(accountsDTO.getMinimumAmountRequired());
        accounts.setBranchState(accountsDTO.getBranchState());
        accounts.setBranchPincode(accountsDTO.getBranchPincode());

        return  accounts;
    }

}
