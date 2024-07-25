package com.bank.SwadeshiBank.Controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.SwadeshiBank.DTO.APIResponseDTO;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.Utils;

@Controller
@RequestMapping(value = "/customer")
public class UsersController {

	private static final Logger log = LogManager.getLogger(UsersController.class);

	@Autowired
	UsersService userServiceImpl;

	
    @GetMapping(value = "/dashboard")
    public String customerDashboard() {
    	log.debug("At admin page");
    	
    	log.info( "Tere naina HSs diye :   : "+Utils.getCurrentUsername());
    	
    	return "User/UserDetails";
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

	@ResponseBody
	@PostMapping("/getAccountDetailsFor/{userName}")
	public APIResponseDTO GetAccountDetalsByUserName(@PathVariable String userName) {
		
		APIResponseDTO apiResponseDTO = new Utils().getDefaultApiResponse();
		List<String> errorList = new ArrayList<String>();
		log.info("Mobile Number: " + userName);

		apiResponseDTO.setData(userServiceImpl.getUserAccountDetails(userName, errorList).toString());
		apiResponseDTO.setMessage(errorList.toString());
		apiResponseDTO.setStatus(HttpStatus.OK);

		return apiResponseDTO;
	}




}
