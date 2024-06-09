package com.bank.SwadeshiBank.Services.Impl;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.Controllers.UsersController;
import com.bank.SwadeshiBank.Entity.Accounts;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Mapper.AccountsMapper;
import com.bank.SwadeshiBank.Repository.AccountsRepository;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;
import com.bank.SwadeshiBank.Utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Services.AccountsService;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountsServiceImpl implements AccountsService {

	private static final Logger log = LogManager.getLogger(AccountsServiceImpl.class);

	@Autowired
	AccountsRepository accountsRepository;

	@Override
	public AccountsDTO createAccount(Users users, UserDTO userDto ,List<String> errorList) {

		log.info("Hi Welcome to the Create Account Method !!  The values you came with are : {} ",
				users + " And for error List we have : {}", errorList);

		AccountsDTO accountDTO = new AccountsDTO();

		try {
			if (!Utils.isNull(users.getUserId()) && users.isActive()) {
				log.info("If condition passed in Create Account method !!");
				
				// Create a new account with default values
				accountDTO.setAccountNumber(RandomStringGenerator.generateRandomNumeric(12));
				accountDTO.setBranchPincode(userDto.getBranchPincode());
				accountDTO.setBranchState(userDto.getBranchState());
				accountDTO.setBranchCity(userDto.getBranchCity());
				accountDTO.setAccountType(userDto.getAccountType());
				accountDTO.setBranchAddress(userDto.getBranchAddress());
				accountDTO.setIfscCode(RandomStringGenerator.generateRandomAlphanumeric(7).toUpperCase());
				accountDTO.setBalanceAmount(userDto.getInitialFunds());
				accountDTO.setInitialFunds(userDto.getInitialFunds());
				accountDTO.setNetBanking(true);

			
				

				Accounts newCreatedAccount = AccountsMapper.mapToAccounts(accountDTO);

				newCreatedAccount.setUserId(users.getUserId());
				
				log.info("New Created account details to be saved are : {}", newCreatedAccount);
				
				
				accountsRepository.save(newCreatedAccount);

				accountDTO = AccountsMapper.mapToAccountsDTO(newCreatedAccount);

			}else {
				errorList.add("Cannot find the user for "+users.getFullname()+ " with username : " +users.getUserName()+" Please try again later or raise a ticket for this issue");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add("Something went wrong while adding account for "+users.getFullname()+ "Please try again later or raise a ticket for this issue");
		}

		return accountDTO;
	}

}
