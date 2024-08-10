package com.bank.SwadeshiBank.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Accounts;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Exceptions.AccountNotFoundException;
import com.bank.SwadeshiBank.Mapper.AccountsMapper;
import com.bank.SwadeshiBank.Repository.AccountsRepository;
import com.bank.SwadeshiBank.Services.AccountsService;
import com.bank.SwadeshiBank.Utils.AddressGenerator;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;
import com.bank.SwadeshiBank.Utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountsServiceImpl implements AccountsService {

	private static final Logger log = LogManager.getLogger(AccountsServiceImpl.class);

	@Autowired
	AccountsRepository accountsRepository;

	@Override
	public AccountsDTO createAccount(Users users, UserDTO userDto ,List<String> errorList) {

		log.info("Hi, Welcome to the Create Account Method !!  The values you came with are : {} ",
				users + " And for error List we have : {}", errorList);

		AccountsDTO accountDTO = new AccountsDTO();

		try {
			log.info("Values of : Utils.isNull(users.getUserId()) && users.isActive()  {} " , users.getUserId() +" : " +  users.isActive());
			if ((!Utils.isNull(users.getUserId()) || !Utils.isNull(users.getUserName())) && users.isActive()) {
				log.info("If condition passed in Create Account method !!");
				
				// Create a new account with default values
				accountDTO.setAccountNumber(RandomStringGenerator.generateRandomNumeric(12));
				accountDTO.setBranchPincode(AddressGenerator.generatePincode());
				accountDTO.setBranchState(AddressGenerator.generateState());
				accountDTO.setBranchCity(AddressGenerator.generateCity());
				accountDTO.setAccountType(userDto.getAccountType());
				accountDTO.setBranchAddress(AddressGenerator.generateAddress());
				accountDTO.setIfscCode(RandomStringGenerator.generateRandomAlphanumeric(7).toUpperCase());
				accountDTO.setBalanceAmount(userDto.getInitialFunds());
				accountDTO.setInitialFunds(userDto.getInitialFunds());
				accountDTO.setNetBanking(userDto.getUPIorNetBanking());

				Accounts newCreatedAccount = AccountsMapper.mapToAccounts(accountDTO);

				newCreatedAccount.setUser(users);
				
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

	@Override
	public List<AccountsDTO> listOfAccounts(List<String> errorList) {

		List<Accounts> accounts = new ArrayList<Accounts>()	;	
		List<AccountsDTO> accountsDTO = new ArrayList<AccountsDTO>();
		try {
			accounts = accountsRepository.findAll(Sort.by(Sort.Direction.ASC,"accountNumber"));
			
			for(Accounts account : accounts) {
				AccountsDTO accountDTO = AccountsMapper.mapToAccountsDTO(account);
				accountsDTO.add(accountDTO);
			}
			log.info("Accounts : " + accountsDTO);
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("Something went bad !! Please try again or contact the Dev team");
		}
		
		return accountsDTO;
	}

	/**
	 * @param accountNumber
	 * @param errorList
	 * @return
	 */
	@Override
	public AccountsDTO getAccountByAccountNumber(Long accountNumber, List<String> errorList) {

        AccountsDTO accountsDTO = null;
        try {
            if (accountNumber != null) {

                Accounts accounts = accountsRepository.findByAccountNumber(accountNumber);
                accountsDTO = AccountsMapper.mapToAccountsDTO(accounts);
            }


        } catch (Exception e) {
            throw new AccountNotFoundException("No Account found with given :" + accountNumber + " number! ");

        }

        return accountsDTO;
    }
}
