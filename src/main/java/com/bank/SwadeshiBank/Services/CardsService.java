package com.bank.SwadeshiBank.Services;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.CardsDTO;
import com.bank.SwadeshiBank.Entity.Users;

import java.util.List;

public interface CardsService {

	public CardsDTO createCards(Users user, AccountsDTO accountsDTO, List<String> errorList);
	
	
}
