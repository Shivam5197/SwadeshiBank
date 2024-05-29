package com.bank.SwadeshiBank.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.SwadeshiBank.Entity.Users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@RequestMapping(value = "/swadeshiBank/v1")
public class PageController {
    public static final Logger logger = LogManager.getLogger(PageController.class);

    @GetMapping(value = "/")
    public String homePage(){
        logger.debug("Request Came to home :");
        return "open/home";
    }

    @GetMapping(value = "/loginPage")
    public String getLoginPage(){
        logger.info("Request Came to login :");
        return "open/login";
    }
    
    
    
    Users usr = new Users();
    

    
    
    
}
