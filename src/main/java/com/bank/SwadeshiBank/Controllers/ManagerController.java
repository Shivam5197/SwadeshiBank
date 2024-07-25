package com.bank.SwadeshiBank.Controllers;

import com.bank.SwadeshiBank.DTO.APIResponseDTO;
import com.bank.SwadeshiBank.DTO.NewAccountsDraftDTO;
import com.bank.SwadeshiBank.Services.ManagerServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/management")
@Controller
public class ManagerController {

	@Autowired
	ManagerServices managerServicesImpl;

	 public static final Logger log = LogManager.getLogger(ManagerController.class);
	@GetMapping("/dashboard")
	public String getManagerDashboard() {
		
		return "Manager/managerDashboard";
	}


	@ResponseBody
	@GetMapping("/pendingAccountList")
	public APIResponseDTO getPendingAccountsList(){

		APIResponseDTO apiResponseDTO = new APIResponseDTO();
		List<String> errorList = new ArrayList<String>();

		List<NewAccountsDraftDTO> newAccountsDraftDTOS = managerServicesImpl.getListOfPendingAccounts(errorList);

//		log.info(" REturn DTOS : " + newAccountsDraftDTOS.toString());
		if(!newAccountsDraftDTOS.isEmpty()){
			apiResponseDTO.setData(newAccountsDraftDTOS.toString());
			apiResponseDTO.setStatus(HttpStatus.OK);
			apiResponseDTO.setMessage("Found the List of New Accounts list!");
		}else {
			apiResponseDTO.setData(newAccountsDraftDTOS.toString());
			apiResponseDTO.setStatus(HttpStatus.BAD_REQUEST);
			apiResponseDTO.setMessage(errorList.toString());
		}
		return  apiResponseDTO;
	}

	@ResponseBody
	@PostMapping("/NewCustomerApprove")
	public APIResponseDTO CustomerApproved(@RequestBody Integer draftId){

		APIResponseDTO apiResponseDTO = new APIResponseDTO();
		List<String> errorList = new ArrayList<String>();
		
		boolean isApproved = managerServicesImpl.UserApproved(draftId,errorList);

		if(isApproved){
			apiResponseDTO.setMessage("Customer added Successfully!");
			apiResponseDTO.setStatus(HttpStatus.OK);
			apiResponseDTO.setData("");
		}else {
			apiResponseDTO.setMessage(errorList.toString());
			apiResponseDTO.setStatus(HttpStatus.NOT_ACCEPTABLE);
			apiResponseDTO.setData("");
		}

		return apiResponseDTO;
	}



}
