package com.bank.SwadeshiBank.Controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.SwadeshiBank.DTO.APIResponseDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.Utils;

@Controller
@RequestMapping
public class UsersController {

	private static final Logger log = LogManager.getLogger(UsersController.class);

	@Autowired
	UsersService userServiceImpl;

	@ResponseBody
	@RequestMapping(value = "/registerNewUser", method = { RequestMethod.GET, RequestMethod.POST })
	public APIResponseDTO registerNewUser() {

		log.info("--------------------------------------Request came-------------------------------------------");
		APIResponseDTO apiResponseDTO = new Utils().getDefaultApiResponse();
		List<String> errorList = new LinkedList<String>();
		UserDTO userDto = new UserDTO();

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//        Date	dob = format.parse(userDto.getDateOfBirth().toString());
//        userDto.setDateOfBirth(dob);
//        } catch (ParseException e) {
//			e.printStackTrace();
//		}

		Boolean isCreated = userServiceImpl.addNewUser(userDto, errorList);

		log.info("===================================================================================================");
		log.info("User DTO toSTring" + userDto.toString());
		log.info("===================================================================================================");

		if (isCreated) {
			apiResponseDTO.setData(userDto.toString());
			apiResponseDTO.setMessage("Saved Successfully");
			apiResponseDTO.setStatus(HttpStatus.OK);
		} else {
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
