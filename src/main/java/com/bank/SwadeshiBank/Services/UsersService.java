package com.bank.SwadeshiBank.Services;

import java.util.List;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Accounts;

public interface UsersService {
	
	public Boolean addNewUser(UserDTO userDto, List<String> errorList);
	
	public UserDTO getUserByMobileNumber(String mobileNumber, List<String> errorList );

	public List<UserDTO> getAllUsers(List<String> errorList);

	public  UserDTO getUserByUserName(String userName,List<String> errorList);
	
	public List<AccountsDTO> getUserAccountDetails(String userName, List<String> errorList);
	
	public UserDTO getUserCardDetails(String userName, List<String> errorList);

	public List<UserDTO> getAllActiveUsers(List<String> errorList);

	public List<Accounts> getUserAccounts(String userName , List<String> errorList);

	public UserDTO getUserDetails(String userName,List<String> errorList);

//	public UPI_Entity getUserUpiData(String username, List<String> errorList);

	public boolean deleteUserByUsername(String userName);
}
