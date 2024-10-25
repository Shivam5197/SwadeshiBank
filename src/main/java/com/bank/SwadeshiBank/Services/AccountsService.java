package com.bank.SwadeshiBank.Services;

import java.util.List;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;

public interface AccountsService {

	public AccountsDTO createAccount(UserDTO userDto ,List<String> errorList);
	
	public List<AccountsDTO> listOfAccounts(List<String> errorList);

	public AccountsDTO getAccountByAccountNumber(Long accountNumber,List<String> errorList);

}
