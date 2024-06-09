package com.bank.SwadeshiBank.Services;

import java.util.List;

import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Users;

public interface UsersService {
	
	public Boolean addNewUser(UserDTO userDto, List<String> errorList);
	
	public UserDTO getUserByMobileNumber(String mobileNumber, List<String> errorList );

	public List<UserDTO> getAllUsers(List<String> errorList);

	public  Users getUserByUserName(String userName,List<String> errorList);

}
