package com.bank.SwadeshiBank.Mapper;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.Entity.Accounts;

public class AccountsMapper {

    public static AccountsDTO mapToAccountsDTO( Accounts accounts){

    	AccountsDTO accountsDTO = new AccountsDTO();
    	accountsDTO.setUserId(accounts.getUserId());
        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setAccountType(accounts.getAccountType());
        accountsDTO.setBalanceAmount(accounts.getBalanceAmount());
        accountsDTO.setBranchCity(accounts.getBranchCity());
        accountsDTO.setBranchAddress(accounts.getBranchAddress());
        accountsDTO.setIfscCode(accounts.getIfscCode());
        accountsDTO.setBranchState(accounts.getBranchState());
        accountsDTO.setBranchPincode(accounts.getBranchPincode());
        accountsDTO.setInitialFunds(accounts.getInitialFunds());
        accountsDTO.setNetBanking(accounts.getNetBanking());
        return  accountsDTO;
    }


    public static Accounts mapToAccounts(AccountsDTO accountsDTO){

    	Accounts accounts = new Accounts();
        accounts.setAccountNumber(accountsDTO.getAccountNumber());
        accounts.setAccountType(accountsDTO.getAccountType());
        accounts.setBalanceAmount(accountsDTO.getBalanceAmount());
        accounts.setBranchCity(accountsDTO.getBranchCity());
        accounts.setBranchAddress(accountsDTO.getBranchAddress());
        accounts.setIfscCode(accountsDTO.getIfscCode());
        accounts.setBranchState(accountsDTO.getBranchState());
        accounts.setBranchPincode(accountsDTO.getBranchPincode());
        accounts.setInitialFunds(accountsDTO.getInitialFunds());
        accounts.setNetBanking(accountsDTO.getNetBanking());

        return  accounts;
    }

}
