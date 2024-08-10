package com.bank.SwadeshiBank.Utils.Mails;

import java.util.List;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.CardsDTO;
import com.bank.SwadeshiBank.Entity.Users;

public interface MailService {

	  public void WelcomeMail(String rawPassword,Users registeredUser, AccountsDTO openedAccount, CardsDTO AssignedCard , List<String> errorList);

	  
		/*
		 * public void SendMail(String from , String mailTo, String subject, String
		 * message);
		 */

}
