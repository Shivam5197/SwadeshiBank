package com.bank.SwadeshiBank.Services;

import java.util.List;

import com.bank.SwadeshiBank.DTO.UserDTO;

public interface UsersService {
	
	public Boolean addNewUser(UserDTO userDto, List<String> errorList);
	
	public UserDTO getUserByMobileNumber(String mobileNumber, List<String> errorList );

	public List<UserDTO> getAllUsers(List<String> errorList);

	public  UserDTO getUserByUserName(String userName,List<String> errorList);
	
	public UserDTO getUserAccountDetails(String userName,List<String> errorList);
	
	public UserDTO getUserCardDetails(String userName, List<String> errorList);

	
}
