package com.bank.SwadeshiBank.Controllers;


import com.bank.SwadeshiBank.DTO.APIResponseDTO;
import com.bank.SwadeshiBank.Utils.Utils;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manager")
public class UsersController {


	
	
    @ResponseBody
    @RequestMapping(value = "/getUsers" , method = {RequestMethod.GET,RequestMethod.POST})
    public APIResponseDTO getUser(){
    	
    	
    	
        APIResponseDTO apiResponseDTO = new Utils().getDefaultApiResponse();

        apiResponseDTO.setData("HELLO DATA");
        apiResponseDTO.setMessage("HEY THERE I AM GELO");
        apiResponseDTO.setStatus(HttpStatus.OK);
        return apiResponseDTO;
    }




}

