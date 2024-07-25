package com.bank.SwadeshiBank.Utils.Mails;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.CardsDTO;
import com.bank.SwadeshiBank.Entity.Card;
import jakarta.mail.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.bank.SwadeshiBank.Entity.Accounts;
import com.bank.SwadeshiBank.Entity.Users;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailserviceImpl implements MailService {

	private static final Logger LOGGER = LogManager.getLogger(MailserviceImpl.class);

//	private JavaMailSender emailSender;

	@Override
	public void WelcomeMail(String initialPass,Users registeredUser, AccountsDTO openedAccount, CardsDTO assignedCard,
			List<String> errorList) {

		try {
			MailDTO myMail = new MailDTO();

			// Load the JSP template file from the classpath
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("templates/MailTemplets/Welcom.html");
			if (inputStream == null) {
				throw new IllegalArgumentException("File not found! templates/WelcomeCustomer.jsp");
			}
			String jspTemplate;
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
				jspTemplate = reader.lines().collect(Collectors.joining(System.lineSeparator()));
			}

			// Format Branch Address
			String BranchAddress = openedAccount.getBranchAddress() + "<br>" + openedAccount.getBranchCity() + ", "
					+ openedAccount.getBranchCity() + "<br>" + openedAccount.getBranchPincode();

			// Set dynamic values
			String htmlContent = jspTemplate.replace("${userName}", registeredUser.getUserName())
					.replace("${fullname}", registeredUser.getFullname()).replace("${password}", initialPass) // Replace
																													// with
																													// actual
																													// password
					.replace("${crn}", registeredUser.getCRN().toString())
					.replace("${accountNumber}", openedAccount.getAccountNumber().toString())
					.replace("${ifscCode}", openedAccount.getIfscCode())
					.replace("${openingamount}", String.valueOf(openedAccount.getInitialFunds().toString()))
					.replace("${branchFullAddress}", BranchAddress)
					.replace("${cardNumber}", assignedCard.getCardNumber().toString());

			myMail.setMESSAGE(htmlContent);
			myMail.setSUBJECT("Welcome to Swadeshi Bank!");
			myMail.setFROM("sharmaascent8@gmail.com");
			myMail.setPASSWORD("deig pvhf ddny seuf");

			// SMTP settings
			String HOST = "smtp.gmail.com";
			Properties properties = System.getProperties();
			properties.put("mail.smtp.host", HOST);
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.auth", "true");

			// Get session object
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myMail.getFROM(), myMail.getPASSWORD());
				}
			});
			session.setDebug(true);

			// Compose the Message
			MimeMessage mime = new MimeMessage(session);
			mime.setFrom(new InternetAddress(myMail.getFROM()));
			mime.addRecipient(Message.RecipientType.TO, new InternetAddress(registeredUser.getEmail()));
			mime.setSubject(myMail.getSUBJECT());
			mime.setContent(myMail.getMESSAGE(), "text/html");

			// Send the message
			Transport.send(mime);
			LOGGER.info("Sent Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("There is some error at our end!! we are trying to resolve it please try after some time");
		}
	}

	/*	*//**
			 * @param from
			 * @param mailTo
			 * @param subject
			 * @param message
			 */
	/*
	 * @Override public void SendMail(String from , String mailTo, String subject,
	 * String message) {
	 * 
	 * try { SimpleMailMessage mailMessage = new SimpleMailMessage();
	 * 
	 * String MAilFrom = from+"@demomailtrap.com"; mailMessage.setFrom(MAilFrom);
	 * mailMessage.setTo(mailTo); mailMessage.setSubject(subject);
	 * mailMessage.setText(message);
	 * 
	 * emailSender.send(mailMessage); } catch (MailException e) { throw new
	 * RuntimeException(e); }
	 * 
	 * }
	 */}
