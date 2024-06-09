package com.bank.SwadeshiBank.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.SwadeshiBank.DTO.APIResponseDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;
import com.bank.SwadeshiBank.Utils.Utils;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@RequestMapping(value = "/swadeshiBank/v1")
public class PageController {
    public static final Logger log = LogManager.getLogger(PageController.class);

    
	@Autowired
	UsersService userServiceImpl;
    
    @GetMapping(value = "/")
    public String homePage(){
    	log.debug("Request Came to home :");
        return "open/home";
    }

    @GetMapping(value = "/loginPage")
    public String getLoginPage(){
    	log.info("Request Came to login :");
        
        
//        APIResponseDTO apiResponseDTO = new Utils().getDefaultApiResponse();
//
//        List<String> errorList = new LinkedList<String>();
//        
//        UserDTO userDto = new UserDTO();
//        
//        userDto.setFirstName("Shivam");
//        userDto.setLastName("Sharma");
//        userDto.setAge(28);
//        userDto.setAadharNumber(RandomStringGenerator.generateRandomNumeric(12).toString());
//        userDto.setPanNumber(RandomStringGenerator.generateRandomAlphanumeric(10).toString());
//        userDto.setMobileNumber("9958093592");
//        userDto.setAddress("C-1008 Kalash Homes");
//        userDto.setCity("Pune");
//        userDto.setPinCode("410251");
//        userDto.setState("Maharasthra");
//        userDto.setUserName("Devil@123");
//        userDto.setProfession("Chhapri");        
//        
//        userDto = userServiceImpl.addNewUser(userDto, errorList);
//        
//        log.info("Everyting passed");
//        
//        apiResponseDTO.setData(userDto.toString());
//        apiResponseDTO.setMessage("SAved Successfully");
//        apiResponseDTO.setStatus(HttpStatus.OK);
////        return apiResponseDTO;
//        log.info(apiResponseDTO.toString());
//        
        
        return "open/login";
    }
    
    
    
    Users usr = new Users();
    

    @GetMapping(value = "/admin")
    public String adminPage() {
    	log.debug("At admin page");
    	
    	return "admin/adminHome";
    	
    }
    
    
}
