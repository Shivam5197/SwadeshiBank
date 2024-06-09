package com.bank.SwadeshiBank.Controllers;


import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.DTO.APIResponseDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Services.Impl.UserServiceImpl;
import com.bank.SwadeshiBank.Utils.AddressGenerator;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;
import com.bank.SwadeshiBank.Utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class UsersController {

	  private static final Logger log = LogManager.getLogger(UsersController.class);
	
	@Autowired
	UsersService userServiceImpl;
	
	@ResponseBody
    @RequestMapping(value = "/registerNewUser" , method = {RequestMethod.GET,RequestMethod.POST})
    public APIResponseDTO registerNewUser(){
    	
    	log.info("--------------------------------------Request came-------------------------------------------");
        APIResponseDTO apiResponseDTO = new Utils().getDefaultApiResponse();

        List<String> errorList = new LinkedList<String>();
        
        UserDTO userDto = new UserDTO();

        
        
        userDto.setFullname(RandomStringGenerator.generateRandomAlphanumeric(8));
        userDto.setFatherName(RandomStringGenerator.generateRandomAlphanumeric(8));
        userDto.setUserType(Constants.UserType.USER);
//        userDto.setUserName("Shivam@511997");
//       userDto.setPassword("Shivam@511997");
        userDto.setMotherName(RandomStringGenerator.generateRandomAlphanumeric(8));
//        userDto.setUserName("Shruti@831995");
//        userDto.setPassword("Shruti@831995");
  
//        userDto.setUserName("sakshi@280521");
//        userDto.setPassword("sakshi@280521");
   
        userDto.setUserName(RandomStringGenerator.generateRandomAlphanumeric(7));
      userDto.setPassword(RandomStringGenerator.generateRandomAlphanumeric(8));
 
        //        userDto.setDateOfBirth("12/12/2012".);

        Calendar calendar = Calendar.getInstance();

        // Set the desired year, month, and day
        calendar.set(Calendar.YEAR, 2202);
        calendar.set(Calendar.MONTH, Calendar.AUGUST); // Note: Months are zero-indexed
        calendar.set(Calendar.DAY_OF_MONTH, 05);
        Date date = calendar.getTime();
        userDto.setDateOfBirth(date);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//          Date	dob = format.parse(userDto.getDateOfBirth().toString());
//          userDto.setDateOfBirth(dob);
//        } catch (ParseException e) {
//			e.printStackTrace();
//		}
        
        userDto.setGender(Constants.Gender.FEMALE);
        userDto.setMaritalStatus("Single");
        userDto.setCategory("SC/ST");
        userDto.setMobileNumber(RandomStringGenerator.generateRandomNumeric(10).toString());
        userDto.setEmail(RandomStringGenerator.generateEmail(18));
        userDto.setAddress(AddressGenerator.generateAddress());
        userDto.setState(AddressGenerator.generateState());
        userDto.setCity(AddressGenerator.generateCity());
        userDto.setPinCode(AddressGenerator.generatePincode());
        userDto.setAadharNumber(RandomStringGenerator.generateRandomNumeric(12).toString());
        userDto.setPanNumber(RandomStringGenerator.generateRandomAlphanumeric(10).toUpperCase());
        userDto.setOccupation(RandomStringGenerator.generateRandomAlphanumeric(8).toUpperCase());
        userDto.setOrganisation(RandomStringGenerator.generateRandomAlphanumeric(8).toUpperCase());
        userDto.setAnnualIncome(RandomStringGenerator.generateRandomNumeric(6));
       
        userDto.setNominieFullName(RandomStringGenerator.generateRandomAlphanumeric(8).toUpperCase());
        userDto.setNominieRelation(RandomStringGenerator.generateRandomAlphanumeric(9).toUpperCase());
        userDto.setNominieMobileNumber(RandomStringGenerator.generateRandomNumeric(10).toString());
        userDto.setNominieAadharNumber(RandomStringGenerator.generateRandomNumeric(12).toString());
        userDto.setNominiePanNumber(RandomStringGenerator.generateRandomAlphanumeric(10).toUpperCase());
        
        userDto.setAccountType(Constants.AccountType.SALARY_ACCOUNT);
        userDto.setInitialFunds(RandomStringGenerator.generateRandomNumeric(4));
        userDto.setNetBanking(true);
        userDto.setBalanceAmount(userDto.getInitialFunds());
        userDto.setBranchAddress(AddressGenerator.generateAddress());
        userDto.setBranchState(AddressGenerator.generateState());
        userDto.setBranchCity(AddressGenerator.generateCity());
        userDto.setBranchPincode(AddressGenerator.generatePincode());
        
        Boolean isCreated = userServiceImpl.addNewUser(userDto, errorList);
        
        log.info("===================================================================================================");
        
        log.info("User DTO" + userDto);
        
        log.info("User DTO toSTring" + userDto.toString());

        log.info("===================================================================================================");
        
        if(isCreated) {
        apiResponseDTO.setData(userDto.toString());
        apiResponseDTO.setMessage("Saved Successfully");
        apiResponseDTO.setStatus(HttpStatus.OK);
        }else {
            apiResponseDTO.setData(userDto.toString());
            apiResponseDTO.setMessage(errorList.toString());
            apiResponseDTO.setStatus(HttpStatus.CONFLICT);
        }
        
        return apiResponseDTO;

	
	}


	@ResponseBody
	@PostMapping("/getUserByMobile/{mobileNumber}")
	public APIResponseDTO searchByMoileNumber(@PathVariable String mobileNumber) {
		
		APIResponseDTO apiResponseDTO = new Utils().getDefaultApiResponse();
		List<String> errorList = new ArrayList<String>();
		log.info("Mobile Number: " + mobileNumber);
		
	apiResponseDTO.setData(userServiceImpl.getUserByMobileNumber(mobileNumber, errorList).toString());
	apiResponseDTO.setMessage(errorList.toString());
	apiResponseDTO.setStatus(HttpStatus.OK);
	
		return apiResponseDTO;
	}
	
	
	
	

}

