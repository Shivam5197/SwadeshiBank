package com.bank.SwadeshiBank.Services;

import java.util.List;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.CardsDTO;
import com.bank.SwadeshiBank.Entity.Users;

public interface CardsService {

	public CardsDTO createCards(Users user, AccountsDTO accountsDTO, List<String> errorList);
	
	
}
