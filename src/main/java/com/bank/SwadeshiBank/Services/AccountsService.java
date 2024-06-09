package com.bank.SwadeshiBank.Services;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Users;

import java.util.List;

public interface AccountsService {

	public AccountsDTO createAccount(Users users, UserDTO userDto ,List<String> errorList);
	
	
	
	
}
