package com.bank.SwadeshiBank.Controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.SwadeshiBank.Services.UsersService;

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

    @GetMapping(value = "/open-account")
    public String registerPage(){
    	//log.debug("Request Came to home :");
        return "open/register";
    }


    @GetMapping("/login")
    public String loginErrorPage(@RequestParam(name = "error", required = false) String error) {
        if (error != null) {
            log.info("Login failed with error message: " + error);
        }
        return "open/login"; // Redirect back to login page
    }

    
    
    @GetMapping(value = "/admin")
    public String adminPage() {
    	log.debug("At admin page");
    	
    	return "admin/adminHome";
    }
    
    
    
}
