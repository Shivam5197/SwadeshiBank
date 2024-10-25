package com.bank.SwadeshiBank.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Users;

public class UserMapper {

//    private static final Logger log = LogManager.getLogger(UserMapper.class);

 

    public static Users mapToUsersEntity(UserDTO userDTO){
    	
    	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = null;
        try {
            dob = sdf.parse(userDTO.getDateOfBirth());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    	
    	Users user = new Users();
    	
    	user.setFullname(userDTO.getFullname());
    	user.setUserName(userDTO.getUserName());
    	user.setPassword(userDTO.getPassword());
    	user.setFatherName(userDTO.getFatherName());
    	user.setMotherName(userDTO.getMotherName());
    	user.setDateOfBirth(dob);
    	user.setGender(userDTO.getGender());
    	user.setMaritalStatus(userDTO.getMaritalStatus());
    	user.setCategory(userDTO.getCategory());
    	user.setMobileNumber(userDTO.getMobileNumber());
    	user.setEmail(userDTO.getEmail());
    	user.setAddress(userDTO.getAddress());
    	user.setState(userDTO.getState());
    	user.setCity(userDTO.getCity());
    	user.setPinCode(userDTO.getPinCode());
    	user.setAadharNumber(userDTO.getAadharNumber());
    	user.setPanNumber(userDTO.getPanNumber());
    	user.setActive(userDTO.isActive());
    	user.setOccupation(userDTO.getOccupation());
    	user.setOrganisation(userDTO.getOrganisation());
    	user.setAnnualIncome(userDTO.getAnnualIncome());

    	user.setNominieFullName(userDTO.getNominieFullName());
    	user.setNominieRelation(userDTO.getNominieRelation());
    	user.setNominieAadharNumber(userDTO.getNominieAadharNumber());
    	user.setNominiePanNumber(userDTO.getNominiePanNumber());
    	user.setNominieMobileNumber(userDTO.getNominieMobileNumber());
    	
    	return user;
    }
    
    
    public static UserDTO mapToUsersDTO(Users user){
    	UserDTO userDTO = new UserDTO();
    	
    	userDTO.setUserId(user.getUserId());
    	userDTO.setFullname(user.getFullname());
    	userDTO.setUserName(user.getUserName());
    	userDTO.setPassword(user.getPassword());
    	userDTO.setFatherName(user.getFatherName());
    	userDTO.setMotherName(user.getMotherName());
    	userDTO.setDateOfBirth(user.getDateOfBirth().toString());
    	userDTO.setGender(user.getGender());
    	userDTO.setMaritalStatus(user.getMaritalStatus());
    	userDTO.setCategory(user.getCategory());
    	userDTO.setMobileNumber(user.getMobileNumber());
    	userDTO.setEmail(user.getEmail());
    	userDTO.setAddress(user.getAddress());
    	userDTO.setState(user.getState());
    	userDTO.setCity(user.getCity());
    	userDTO.setPinCode(user.getPinCode());
    	userDTO.setAadharNumber(user.getAadharNumber());
    	userDTO.setPanNumber(user.getPanNumber());
    	userDTO.setActive(user.isActive());
    	userDTO.setOccupation(user.getOccupation());
    	userDTO.setOrganisation(user.getOrganisation());
    	userDTO.setAnnualIncome(user.getAnnualIncome());
		userDTO.setCRN(user.getCRN());

    	userDTO.setNominieFullName(user.getNominieFullName());
    	userDTO.setNominieRelation(user.getNominieRelation());
    	userDTO.setNominieAadharNumber(user.getNominieAadharNumber());
    	userDTO.setNominiePanNumber(user.getNominiePanNumber());
    	userDTO.setNominieMobileNumber(user.getNominieMobileNumber());

    	
    	return userDTO;
    }

}
