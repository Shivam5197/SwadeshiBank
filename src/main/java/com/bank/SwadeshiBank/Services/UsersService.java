package com.bank.SwadeshiBank.Services;

import java.util.List;

import com.bank.SwadeshiBank.DTO.UserDTO;

public interface UsersService {
	
	public UserDTO addNewUser(UserDTO userDto, List<String> errorList);
	

}
