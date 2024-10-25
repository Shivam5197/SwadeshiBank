package com.bank.SwadeshiBank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bank.SwadeshiBank.DTO.UPIDTO;
import com.bank.SwadeshiBank.Entity.NetBankingEntity;
import com.bank.SwadeshiBank.Entity.UPI_Entity;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Mapper.UserMapper;
import com.bank.SwadeshiBank.Utils.Documents.PDFGeneratorService;
import com.bank.SwadeshiBank.Utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Services.AccountsService;
import com.bank.SwadeshiBank.Services.CardsService;
import com.bank.SwadeshiBank.Services.NetBankingService;
import com.bank.SwadeshiBank.Services.UPIService;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.Mails.MailService;
import org.springframework.context.annotation.Lazy;

@SpringBootTest
class SwadeshiBankApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MailService mailService;

	@Autowired
	CardsService cardsService;

	@Autowired
	UsersService usersService;

	@Autowired
	AccountsService accountsService;

	@Autowired
	UPIService upiService;

	@Autowired
	NetBankingService netBankingService;

	@Lazy
	@Autowired
	PDFGeneratorService pdfGeneratorService;

//	@Test
//	void sendEmailTest(){
//	  mailService.SendMail("hello","sharmaascent8@gmail.com", "Testing mail" , "Hello baby");
//	}

/*
	@Test
	void checkCards(){
		Long id = 2L;
		cardsService.getCardByUser(id,new ArrayList<String>());

	}
*/

//	@Test
//	void  Allusers(){
//
//		System.out.print(usersService.getAllUsers(new ArrayList<String>()).toString());
//
//	}


//	@Test
//	void GetUserDetails(){
//
//	UserDTO userDTO	= usersService.getUserDetails("Shruti@831995" , new ArrayList<String>());
//
//	}

//	@Test
//		void upiDetails(){
//
//			usersService.getUserUpiData("Shivam@511997" , new ArrayList<String>()).toString();
//
//		}

//	@Test
//	void createUPI(){
////		UPIDTO upidto = new UPIDTO();
////		upidto.setUPI_CODE("123456");
//
//		UPI_Entity newUPI = upiService.generateUPIId(null, "23jmmPo", 41392530479L,new ArrayList<String>())
//		;
//		System.out.println("UPI Entity : " + newUPI.toString());
//	}

//	@Test
//	void createNetBAnking(){
//
//	NetBankingEntity netBankingEntity =  netBankingService.generateNetBanking("23jmmPo",41392530479L, new ArrayList<String>());
//		System.out.println("netBankingEntity Entity : " + netBankingEntity.toString());
//	}


//	@Test
//	void AddAccount(){
//
//			UserDTO userDto =  usersService.getUserByUserName("5sI4KNA", new ArrayList<String>());
//			Users users = UserMapper.mapToUsersEntity(userDto);
//		System.out.println("Users DTO : " + userDto);
//
//		System.out.println("Users Entity : " + users);
//		 accountsService.createAccount(userDto, new ArrayList<String>());
//
//
//	}

//	@Test
//	void  getAccounts(){
////		UserDTO userDto =  usersService.getUserByUserName("Shivam@511997", new ArrayList<String>());
////		Users users = UserMapper.mapToUsersEntity(userDto);
//
////		System.out.println(usersService.getUserAccountDetails("Shivam@511997" ,  new ArrayList<String>()));
//
//		System.out.println(usersService.getUserAccounts("Shivam@511997" ,  new ArrayList<String>()));
//	}


//	@Test
//	void SendMailWithAttachment(){
//
//		Map<String, String> replacements = new HashMap<>();
//		replacements.put("accountHolderName", "Test Customer");
//		replacements.put("accountNumber", "894651233123");
//		replacements.put("balance", "4131");
//
//		try {
//			String templatePath = "src/main/resources/templates/DocumentTemplets/WelcomePDF.html";
//			String htmlContent = pdfGeneratorService.loadAndFillTemplate(templatePath, replacements);
//
//			// Use customer's date of birth as the password for the PDF
//			String password = "TestPassword";  // Assume format is DDMMYYYY
//
//			byte[] pdfData = pdfGeneratorService.generateWelcomePDF(htmlContent, password);
//			String subject = "Your Account Details";
//			String body = "Please find attached your account details.";
//
////			mailService.EmailWithAttachment("sharmaascent6@gmail.com", subject, body, pdfData, "AccountDetails.pdf");
//
//
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//
//	}

// @Test
//	void dateTimeCheck(){
//		UserDTO userDto =  usersService.getUserByUserName("george.red36", new ArrayList<String>());
//			Users users = UserMapper.mapToUsersEntity(userDto);
//		System.out.println("Users DTO : " + userDto);
//	 String docPass = (userDto.getCRN() +"@"+ Utils.formatDateToDDMMYYYY(userDto.getDateOfBirth().toString())).toString();
//
//	 System.out.println("docPass : " + docPass);
// }
//
//
// @Test
//	void deleteByUserName(){
//	 usersService.deleteUserByUsername("Shruti 8998");
// }

}


