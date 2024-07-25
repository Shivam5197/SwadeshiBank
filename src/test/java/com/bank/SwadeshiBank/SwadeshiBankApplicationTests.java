package com.bank.SwadeshiBank;

import com.bank.SwadeshiBank.Services.CardsService;
import com.bank.SwadeshiBank.Utils.Mails.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class SwadeshiBankApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MailService mailService;

	@Autowired
	CardsService cardsService;

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



}


