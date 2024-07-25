package com.bank.SwadeshiBank.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.SwadeshiBank.DTO.APIResponseDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Services.ManagerServices;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.Utils;

@Controller
@RequestMapping
public class OpenAccountController {

    public static final Logger log = LogManager.getLogger(OpenAccountController.class);

	@Autowired
	UsersService userServiceImpl;

	@Autowired
	ManagerServices managerServicesImpl;
	
	@ResponseBody
	@RequestMapping(value = "/registerNewUser", method = { RequestMethod.GET, RequestMethod.POST })
	public APIResponseDTO registerNewUser(@ModelAttribute UserDTO user) {

		log.info("+=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=+");
		log.info("User Dto Came with Values : " + user.toString());
		log.info("+=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=++=+=+=+");

		
		APIResponseDTO apiResponseDTO = new Utils().getDefaultApiResponse();
		List<String> errorList = new LinkedList<String>();

//		Boolean isCreated = userServiceImpl.addNewUser(user, errorList);

		Boolean ToVerify = managerServicesImpl.verifyUserToOpenAccount(user, errorList);

		log.info("===================================================================================================");
		log.info("User DTO toSTring" + user.toString());
		log.info("===================================================================================================");

		if (ToVerify) {
			apiResponseDTO.setData(user.toString());
			apiResponseDTO.setMessage("We have Your Details! Will be back to you once Verify your details! ");
			apiResponseDTO.setStatus(HttpStatus.OK);
		} else {
			apiResponseDTO.setData(user.toString());
			apiResponseDTO.setMessage(errorList.toString());
			apiResponseDTO.setStatus(HttpStatus.CONFLICT);
		}

		return apiResponseDTO;

	}
    
	
	
}
