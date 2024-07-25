package com.bank.SwadeshiBank.Mapper;

import com.bank.SwadeshiBank.DTO.NewAccountsDraftDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.NewAccountsDrafts;

public class NewAccountsMapper {

	

    public static NewAccountsDrafts mapToNewAccountsDraftsEntity(NewAccountsDraftDTO userDTO){
    	
    	
    	NewAccountsDrafts newAccountUser = new NewAccountsDrafts();
    	
    	newAccountUser.setDaftId(userDTO.getDaftId());
    	newAccountUser.setFullname(userDTO.getFullname());
    	newAccountUser.setUserName(userDTO.getUserName());
    	newAccountUser.setFatherName(userDTO.getFatherName());
    	newAccountUser.setMotherName(userDTO.getMotherName());
    	newAccountUser.setDateOfBirth(userDTO.getDateOfBirth());
    	newAccountUser.setGender(userDTO.getGender());
    	newAccountUser.setMaritalStatus(userDTO.getMaritalStatus());
    	newAccountUser.setCategory(userDTO.getCategory());
    	newAccountUser.setMobileNumber(userDTO.getMobileNumber());
    	newAccountUser.setEmail(userDTO.getEmail());
    	newAccountUser.setAddress(userDTO.getAddress());
    	newAccountUser.setState(userDTO.getState());
    	newAccountUser.setCity(userDTO.getCity());
    	newAccountUser.setPinCode(userDTO.getPinCode());
    	newAccountUser.setAadharNumber(userDTO.getAadharNumber());
    	newAccountUser.setPanNumber(userDTO.getPanNumber());
    	newAccountUser.setOccupation(userDTO.getOccupation());
    	newAccountUser.setOrganisation(userDTO.getOrganisation());
    	newAccountUser.setAnnualIncome(userDTO.getAnnualIncome());
    	newAccountUser.setInitialFunds(userDTO.getInitialFunds());
    	newAccountUser.setNominieFullName(userDTO.getNominieFullName());
    	newAccountUser.setNominieRelation(userDTO.getNominieRelation());
    	newAccountUser.setNominieAadharNumber(userDTO.getNominieAadharNumber());
    	newAccountUser.setNominiePanNumber(userDTO.getNominiePanNumber());
    	newAccountUser.setNominieMobileNumber(userDTO.getNominieMobileNumber());
    	
    	return newAccountUser;
    }
    
    
    public static NewAccountsDraftDTO mapToNewAccountsDraftsDTO(NewAccountsDrafts user){
    	NewAccountsDraftDTO accountsDraftDTO = new NewAccountsDraftDTO();
    	
    	accountsDraftDTO.setDaftId(user.getDaftId());
    	accountsDraftDTO.setFullname(user.getFullname());
    	accountsDraftDTO.setUserName(user.getUserName());
    	accountsDraftDTO.setFatherName(user.getFatherName());
    	accountsDraftDTO.setMotherName(user.getMotherName());
    	accountsDraftDTO.setDateOfBirth(user.getDateOfBirth());
    	accountsDraftDTO.setGender(user.getGender());
    	accountsDraftDTO.setMaritalStatus(user.getMaritalStatus());
    	accountsDraftDTO.setCategory(user.getCategory());
    	accountsDraftDTO.setMobileNumber(user.getMobileNumber());
    	accountsDraftDTO.setEmail(user.getEmail());
    	accountsDraftDTO.setAddress(user.getAddress());
    	accountsDraftDTO.setState(user.getState());
    	accountsDraftDTO.setCity(user.getCity());
    	accountsDraftDTO.setPinCode(user.getPinCode());
    	accountsDraftDTO.setAadharNumber(user.getAadharNumber());
    	accountsDraftDTO.setPanNumber(user.getPanNumber());
    	accountsDraftDTO.setOccupation(user.getOccupation());
    	accountsDraftDTO.setOrganisation(user.getOrganisation());
    	accountsDraftDTO.setAnnualIncome(user.getAnnualIncome());
    	accountsDraftDTO.setInitialFunds(user.getInitialFunds());
    	accountsDraftDTO.setNominieFullName(user.getNominieFullName());
    	accountsDraftDTO.setNominieRelation(user.getNominieRelation());
    	accountsDraftDTO.setNominieAadharNumber(user.getNominieAadharNumber());
    	accountsDraftDTO.setNominiePanNumber(user.getNominiePanNumber());
    	accountsDraftDTO.setNominieMobileNumber(user.getNominieMobileNumber());

    	
    	return accountsDraftDTO;
    }



	public static NewAccountsDraftDTO mapUserDtoToNewAccountsDraftDTO(UserDTO user){
		NewAccountsDraftDTO accountsDraftDTO = new NewAccountsDraftDTO();

//		accountsDraftDTO.setDaftId(user.getUserId().to);
		accountsDraftDTO.setFullname(user.getFullname());
		accountsDraftDTO.setUserName(user.getUserName());
		accountsDraftDTO.setFatherName(user.getFatherName());
		accountsDraftDTO.setMotherName(user.getMotherName());
		accountsDraftDTO.setDateOfBirth(user.getDateOfBirth());
		accountsDraftDTO.setGender(user.getGender());
		accountsDraftDTO.setMaritalStatus(user.getMaritalStatus());
		accountsDraftDTO.setCategory(user.getCategory());
		accountsDraftDTO.setMobileNumber(user.getMobileNumber());
		accountsDraftDTO.setEmail(user.getEmail());
		accountsDraftDTO.setAddress(user.getAddress());
		accountsDraftDTO.setState(user.getState());
		accountsDraftDTO.setCity(user.getCity());
		accountsDraftDTO.setPinCode(user.getPinCode());
		accountsDraftDTO.setAadharNumber(user.getAadharNumber());
		accountsDraftDTO.setPanNumber(user.getPanNumber());
		accountsDraftDTO.setOccupation(user.getOccupation());
		accountsDraftDTO.setOrganisation(user.getOrganisation());
		accountsDraftDTO.setAnnualIncome(user.getAnnualIncome());
		accountsDraftDTO.setInitialFunds(user.getInitialFunds());
		accountsDraftDTO.setNominieFullName(user.getNominieFullName());
		accountsDraftDTO.setNominieRelation(user.getNominieRelation());
		accountsDraftDTO.setNominieAadharNumber(user.getNominieAadharNumber());
		accountsDraftDTO.setNominiePanNumber(user.getNominiePanNumber());
		accountsDraftDTO.setNominieMobileNumber(user.getNominieMobileNumber());


		return accountsDraftDTO;
	}


	public static UserDTO mapToUsersDTO(NewAccountsDraftDTO accountsDraftDTO){
		UserDTO user = new UserDTO();

		user.setFullname(accountsDraftDTO.getFullname());
		user.setUserName(accountsDraftDTO.getUserName());
		user.setFatherName(accountsDraftDTO.getFatherName());
		user.setMotherName(accountsDraftDTO.getMotherName());
		user.setDateOfBirth(accountsDraftDTO.getDateOfBirth());
		user.setGender(accountsDraftDTO.getGender());
		user.setMaritalStatus(accountsDraftDTO.getMaritalStatus());
		user.setCategory(accountsDraftDTO.getCategory());
		user.setMobileNumber(accountsDraftDTO.getMobileNumber());
		user.setEmail(accountsDraftDTO.getEmail());
		user.setAddress(accountsDraftDTO.getAddress());
		user.setState(accountsDraftDTO.getState());
		user.setCity(accountsDraftDTO.getCity());
		user.setPinCode(accountsDraftDTO.getPinCode());
		user.setAadharNumber(accountsDraftDTO.getAadharNumber());
		user.setPanNumber(accountsDraftDTO.getPanNumber());
		user.setOccupation(accountsDraftDTO.getOccupation());
		user.setOrganisation(accountsDraftDTO.getOrganisation());
		user.setAnnualIncome(accountsDraftDTO.getAnnualIncome());
		user.setInitialFunds(accountsDraftDTO.getInitialFunds());
		user.setNominieFullName(accountsDraftDTO.getNominieFullName());
		user.setNominieRelation(accountsDraftDTO.getNominieRelation());
		user.setNominieAadharNumber(accountsDraftDTO.getNominieAadharNumber());
		user.setNominiePanNumber(accountsDraftDTO.getNominiePanNumber());
		user.setNominieMobileNumber(accountsDraftDTO.getNominieMobileNumber());
		return user;
	}

}
