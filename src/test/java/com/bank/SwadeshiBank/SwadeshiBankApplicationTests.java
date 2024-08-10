package com.bank.SwadeshiBank;

import java.util.ArrayList;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Mapper.UserMapper;
import com.bank.SwadeshiBank.Services.AccountsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.SwadeshiBank.DTO.UPIDTO;
import com.bank.SwadeshiBank.Services.CardsService;
import com.bank.SwadeshiBank.Services.UPIService;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.Mails.MailService;

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
	/*
	 * @Test void sendEmailTest(){
	 * mailService.SendMail("hello","sharmaascent8@gmail.com", "Testing mail" ,
	 * "Hello baby"); }
	 */

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
//		void upiDetails(){
//
//			usersService.getUserUpiData("Shivam@511997" , new ArrayList<String>()).toString();
//
//		}

//	@Test
//	void createUPI(){
//		UPIDTO upidto = new UPIDTO();
//		upidto.setUPI_CODE("123456");
//
//		upiService.generateUPIId(upidto, "Shivam@511997", 7997154309L,new ArrayList<String>())
//		;
//	}

	@Test
	void AddAccount(){

			UserDTO userDto =  usersService.getUserByUserName("Shivam@511997", new ArrayList<String>());
			Users users = UserMapper.mapToUsersEntity(userDto);
		System.out.println("Users DTO : " + userDto);

		System.out.println("Users Entity : " + users);
		 accountsService.createAccount(users, userDto, new ArrayList<String>());


	}

//	@Test
//	void  getAccounts(){
////		UserDTO userDto =  usersService.getUserByUserName("Shivam@511997", new ArrayList<String>());
////		Users users = UserMapper.mapToUsersEntity(userDto);
//
////		System.out.println(usersService.getUserAccountDetails("Shivam@511997" ,  new ArrayList<String>()));
//
//		System.out.println(usersService.getUserAccounts("Shivam@511997" ,  new ArrayList<String>()));
//	}



}


