package com.bank.SwadeshiBank.Utils.Mails;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import com.bank.SwadeshiBank.Utils.Documents.PDFGeneratorService;
import jakarta.mail.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.CardsDTO;
import com.bank.SwadeshiBank.Entity.Users;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailserviceImpl implements MailService {


	private static final Logger LOGGER = LogManager.getLogger(MailserviceImpl.class);

	@Override
	public void WelcomeMail(String initialPass, Users registeredUser, AccountsDTO openedAccount, CardsDTO assignedCard,
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
			myMail.setSUBJECT("Welcome to Swadeshi Bank,"+registeredUser.getFullname()+" !");
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


	/**
	 * @param to
	 * @param subject
	 * @param body
	 * @param attachmentData
	 * @param attachmentName
	 */
	public void EmailWithAttachment(String to, String subject, String body, byte[] attachmentData, String attachmentName) {

		try {
			MailDTO myMail = new MailDTO();
			myMail.setMESSAGE("Hello this is welcome mail ");
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
			session.setDebug(false);

			// Compose the Message
			MimeMessage mime = new MimeMessage(session);
			MimeMessageHelper helper = new MimeMessageHelper(mime ,true);

			helper.setFrom(new InternetAddress(myMail.getFROM()));
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(myMail.getMESSAGE());
			helper.addAttachment(attachmentName,new ByteArrayResource(attachmentData));
			// Send the message
			Transport.send(helper.getMimeMessage());

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/**

	 * @param registeredUser
	 * @param openedAccount
	 * @param AssignedCard
	 * @param errorList
	 * @param attachmentData
	 * @param attachmentName
	 */
	@Override
	public void WelcomeEmailWithAttachment( Users registeredUser, AccountsDTO openedAccount, CardsDTO AssignedCard, List<String> errorList, byte[] attachmentData, String attachmentName) {

		try {
			MailDTO myMail = new MailDTO();

			// Load the JSP template file from the classpath
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("templates/MailTemplets/Welcom.html");
			if (inputStream == null) {
				throw new IllegalArgumentException("File not found! templates/Welcom.html");
			}
			String jspTemplate;
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
				jspTemplate = reader.lines().collect(Collectors.joining(System.lineSeparator()));
			}
			// Set dynamic values
			String htmlContent = jspTemplate
				    .replace("${fullname}", registeredUser.getFullname())
				    .replace("${crn}", registeredUser.getCRN().toString());
			
			myMail.setMESSAGE(htmlContent);
			myMail.setSUBJECT("Welcome to Swadeshi Bank,"+registeredUser.getFullname()+" !");
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
			MimeMessageHelper helper = new MimeMessageHelper(mime ,true);

			helper.setFrom(new InternetAddress(myMail.getFROM()));
			helper.setTo(registeredUser.getEmail());
			helper.setSubject(myMail.getSUBJECT());
			//helper.setText(myMail.getMESSAGE());
			helper.setText(myMail.getMESSAGE(), true);

			helper.addAttachment(attachmentName,new ByteArrayResource(attachmentData));
			// Send the message
			Transport.send(helper.getMimeMessage());

			// Send the message
			Transport.send(mime);
			LOGGER.info("Sent Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("There is some error at our end!! we are trying to resolve it please try after some time");
		}
	}
}
