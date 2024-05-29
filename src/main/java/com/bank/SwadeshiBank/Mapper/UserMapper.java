package com.bank.SwadeshiBank.Mapper;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserMapper {

    private static final Logger log = LogManager.getLogger(UserMapper.class);

    public static Users mapToUsersEntity(UserDTO userDTO , Users users, List<String> errorList){
        log.debug("mapToCustomerEntity:     ---> {}", userDTO.toString());
        users.setFirstName(userDTO.getFirstName());
        users.setLastName(userDTO.getLastName());
//        users.setActive(user);
        users.setAge(userDTO.getAge());
        users.setAddharNumber(userDTO.getAadharNumber());
        users.setPanNumber(userDTO.getPanNumber());
        users.setMobileNumber(userDTO.getMobileNumber());
        users.setAddress(userDTO.getAddress());
        users.setCity(userDTO.getCity());
        users.setPinCode(userDTO.getPinCode());
        users.setState(userDTO.getState());
        users.setUserName(userDTO.getUserName());
        users.setProfession(userDTO.getProfession());
        return users;
    }
    public static UserDTO mapToUsersDTO(UserDTO userDTO , Users users, List<String> errorList){
            userDTO.setFirstName(users.getFirstName());
            userDTO.setLastName(users.getLastName());
            userDTO.setActive(users.isActive());
            userDTO.setAge(users.getAge());
            userDTO.setAadharNumber(users.getAddharNumber());
            userDTO.setPanNumber(users.getPanNumber());
            userDTO.setMobileNumber(users.getMobileNumber());
            userDTO.setAddress(users.getAddress());
            userDTO.setCity(users.getCity());
            userDTO.setPinCode(users.getPinCode());
            userDTO.setState(users.getState());
            userDTO.setUserName(users.getUserName());
            userDTO.setProfession(users.getProfession());
        return userDTO;
    }




}
