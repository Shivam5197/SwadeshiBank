package com.bank.SwadeshiBank.Services.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.SwadeshiBank.Constants.URLHelperConstants;
import com.bank.SwadeshiBank.Utils.Documents.PDFGeneratorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.CardsDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Accounts;
import com.bank.SwadeshiBank.Entity.Authority;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Exceptions.AccountNotFoundException;
import com.bank.SwadeshiBank.Mapper.AccountsMapper;
import com.bank.SwadeshiBank.Mapper.UserMapper;
import com.bank.SwadeshiBank.Repository.UsersRepository;
import com.bank.SwadeshiBank.Services.AccountsService;
import com.bank.SwadeshiBank.Services.CardsService;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;
import com.bank.SwadeshiBank.Utils.Utils;
import com.bank.SwadeshiBank.Utils.Mails.MailService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	AccountsService accountService;

	@Autowired
	CardsService cardsService;

	@Autowired
	UsersRepository userRepository;

	@Autowired
	MailService mailService;

	@Lazy
	@Autowired
	PDFGeneratorService pdfGeneratorService;

//	@Autowired
//	UPIService upiService;


	@Override
	public Boolean addNewUser(UserDTO userDto, List<String> errorList) {
		Boolean isCreated = false;
		Users userEntity = new Users();

		log.info("Welcome to the add new User method ----------------------------------------------");
		try {

			if (!Utils.isNull(userDto.getMobileNumber()) & !Utils.isNull(userDto.getAadharNumber())
					& !Utils.isNull(userDto.getPanNumber())
					& !Utils.isNull(userDto.getUserName())
					& !Utils.isNull(userDto.getEmail())) {
	
					userEntity = UserMapper.mapToUsersEntity(userDto);
					String rawPassword = RandomStringGenerator.generateRandomAlphanumericSpecial(16);
											
					userEntity.setPassword(new BCryptPasswordEncoder()
							.encode(rawPassword));
						userEntity.setActive(Constants.UserActive.ACTIVE);
						
						if (userDto.getUserType() == null) {
						    // Default authority for null userType
						    Authority authority = new Authority();
						    authority.setAuthority(Constants.Authority.USER);
						    userEntity.addAuthority(authority);
						} else if (userDto.getUserType().equals(Constants.UserType.ADMIN)) {
						    Authority authority = new Authority();
						    authority.setAuthority(Constants.Authority.ADMIN);
						    userEntity.addAuthority(authority);
						} else if (userDto.getUserType().equals(Constants.UserType.MANAGER)) {
						    Authority authority = new Authority();
						    authority.setAuthority(Constants.Authority.MANAGER);
						    userEntity.addAuthority(authority);
						}
						int tempCRN = RandomStringGenerator.generateRandomNumeric(6).intValue();
						userEntity.setCRN(tempCRN);
						
//						log.info("Entity we are going to save is : ---> {}", userEntity);
						userEntity = userRepository.save(userEntity);

//						log.info("Saved entity : ---> {}", userEntity);
						AccountsDTO accountsDTO = accountService.createAccount(userDto,errorList);
						CardsDTO cardDTO = cardsService.createCards(userEntity, accountsDTO, errorList);


					// Nothing failed so setting isCreated = true;
						isCreated =true;

						if(isCreated){
							// Format Branch Address
							String BranchAddress = accountsDTO.getBranchAddress() + "<br>" + accountsDTO.getBranchCity() + ", "
									+ accountsDTO.getBranchCity() + "<br>" + accountsDTO.getBranchPincode();

							//log.info(rawPassword);
//							userEntity.setPassword(rawPassword);
							Map<String , String> replacements = new HashMap<>();
							replacements.put("accountNumber", accountsDTO.getAccountNumber().toString());
							replacements.put("crn",userEntity.getCRN().toString());
							replacements.put("ifscCode",accountsDTO.getIfscCode());
							replacements.put("openingamount",accountsDTO.getInitialFunds().toString());
							replacements.put("password",rawPassword);
							replacements.put("branchFullAddress",BranchAddress);
							replacements.put("cardNumber",cardDTO.getCardNumber().toString());
							replacements.put("expiryDate",cardDTO.getExpiryDate());
							replacements.put("cvv",cardDTO.getCvv().toString());
							replacements.put("userID",accountsDTO.getNetBankingEntity().getUserName());
							replacements.put("netBankingPassword",accountsDTO.getNetBankingEntity().getPassword());
							replacements.put("upiID",accountsDTO.getUpiEntity().getUpiId());
							replacements.put("upiPin",accountsDTO.getUpiEntity().getUPI_CODE());

							log.info("{URLHelperConstants.WELCOMEMAILTEMPLET}"+URLHelperConstants.WELCOMEMAILTEMPLET);
							//String templatePath = "src/main/resources/templates/DocumentTemplets/WelcomePDF.html";
							String htmlContent = pdfGeneratorService.loadAndFillTemplate(URLHelperConstants.WELCOMEMAILTEMPLET, replacements);

							String docPass = ( tempCRN+"@"+ Utils.formatDateToDDMMYYYY(userDto.getDateOfBirth().toString())).toString();
//							log.info("Document Password : " +docPass);

							byte[] pdfData = pdfGeneratorService.generateWelcomePDF(htmlContent, docPass);

							//mailService.WelcomeMail(rawPassword,userEntity, accountsDTO,cardDTO,errorList);
							mailService.WelcomeEmailWithAttachment(userEntity,accountsDTO,cardDTO,errorList,pdfData,"AccountDetails.pdf");
						}

			} else {
				errorList.add("Please provide required details!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("Something Went wrong please try again ! ");
		}

		log.debug("============================================================== createdUserDto");

		return isCreated;
	}

	@Override
	public UserDTO getUserByMobileNumber(String mobileNumber, List<String> errorList) {
		UserDTO userDto = new UserDTO();
		try {

			Users user = userRepository.findByMobileNumber(mobileNumber);

			userDto = UserMapper.mapToUsersDTO(user);

			log.info("User Fetched is :"+ userDto.toString());
			
		} catch (Exception e) {
			errorList.add("Customer with given number " + mobileNumber + " Does not exists!");
			e.printStackTrace();
		}

		return userDto;
	}

	@Override
	public List<UserDTO> getAllUsers(List<String> errorList) {

		List<UserDTO> userDto = new ArrayList<UserDTO>();

		try {
			List<Users> users = userRepository.findAll();

			for (int i = 0; i < users.size(); i++) {
				Users user = users.get(i);
				UserDTO usersDto = UserMapper.mapToUsersDTO(user);
				userDto.add(usersDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("Somethig went wrong !");
		}

		return userDto;
	}
		
	public boolean checkDetailsBeforeSavingUsers(UserDTO userDto, List<String> errorList) {
		
		boolean isPresent = true;
		
		Users user = new Users();
		
		/*
		 * This function is to check if the an user with this unique values present in
		 * the System or Not
		 */
		
		user = userRepository.findByMobileNumber(userDto.getMobileNumber());
		if(user.getMobileNumber().isEmpty()) {
			isPresent =false;
		}else {
			isPresent = true;
			errorList.add("User with this Mobile Number already exist ! Please try another Mobile Number or login!");
			return isPresent;
		}

		user = userRepository.findByAadharNumber(userDto.getAadharNumber());
		if(user.getMobileNumber().isEmpty()) {
			isPresent =false;
		}else {
			isPresent = true;
			errorList.add("User with this Aadhar number already exist ! Please try another Aadhar number or login!");
			return isPresent;
		}

		
		user = userRepository.findByEmail(userDto.getEmail());
		if(user.getMobileNumber().isEmpty()) {
			isPresent =false;
		}else {
			isPresent = true;
			errorList.add("User with this Email Id already exist ! Please try another Email or login!");
			return isPresent;
		}

		user = userRepository.findByPanNumber(userDto.getPanNumber());
		if(user.getMobileNumber().isEmpty()) {
			isPresent =false;
		}else {
			isPresent = true;
			errorList.add("User with this Pan number already exist ! Please try another Pan number or login!");
			return isPresent;
		}

		user = userRepository.findByUserName(userDto.getUserName()).orElseThrow(()->(new UsernameNotFoundException("User with :" + userDto.getUserName() +" Not found")));
		if(user.getMobileNumber().isEmpty()) {
			isPresent =false;
		}else {
			isPresent = true;
			errorList.add("User with this UserName  already exist ! Please try another UserName or login!");
			return isPresent;
		}

		return isPresent;
	}

	@Override
	public UserDTO getUserByUserName(String userName,List<String> errorList) throws UsernameNotFoundException {

		Users user = new Users();
		UserDTO userDTO = new UserDTO();
		try {
			
			if(!Utils.isNull(userName)) {
				
				user = userRepository.findByUserName(userName).orElseThrow(()->(new UsernameNotFoundException("User with :" + userName +" Not found")));
				userDTO = UserMapper.mapToUsersDTO(user);
			}else {
				errorList.add("Username cannot be blank");
			}
			
		} catch (Exception e) {
			errorList.add("User not found with this username "+ userName);
			e.printStackTrace();
			throw new UsernameNotFoundException("User not found with this username "+ userName);
		}
		
		return userDTO;
	}

	@Override
	public List<AccountsDTO> getUserAccountDetails(String userName, List<String> errorList) {
		UserDTO userDto = new UserDTO();
		Users user = new Users();
		List<AccountsDTO> accountsDTO = new ArrayList<AccountsDTO>();

		try {

			if(!userName.isEmpty()) {

				user = userRepository.findByUserName(userName).orElseThrow(()->(new UsernameNotFoundException("User with :" + userName +" Not found")));

				log.info("User Accounts Details : {}" , user);

				log.info("User getAuthorities Details : {}" , user.getAuthorities());
				log.info("User getAccountsSet Details : {}" , user.getAccountsSet());
				log.info("User getCardSet Details : {}" , user.getCardSet());
				log.info("User getLoansSet Details : {}" , user.getLoansSet());
				log.info("User getTransactionsSet Details : {}" , user.getTransactionsSet());

				List<Accounts> accounts = 	user.getAccountsSet();
				for(Accounts account : accounts){
					accountsDTO.add(AccountsMapper.mapToAccountsDTO(account));
				}

			}else {
				errorList.add("Please provide the User Name, Phone Number or Email to find the Customer Details !");
			}

		} catch (Exception e) {
			throw new AccountNotFoundException("No account found for this user");
		}
		return accountsDTO;
	}

	@Override
	public UserDTO getUserCardDetails(String userName, List<String> errorList) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param errorList
	 * @return
	 */
	@Override
	public List<UserDTO> getAllActiveUsers(List<String> errorList) {
		List<UserDTO> userDTOS = new ArrayList<>();

		try {

		List<Users>	 users	= userRepository.findAll();

		for(Users users1 : users){
		userDTOS.add(	UserMapper.mapToUsersDTO(users1));
		}

		log.info("All users are here  :::::::::::: " +userDTOS.toString());

		}catch (Exception e){

			e.printStackTrace();
		}
		return userDTOS;
	}


	@Override
	public List<Accounts> getUserAccounts(String userName, List<String> errorList){
		UserDTO userDto = new UserDTO();
		Users user = new Users();

		List<Accounts> accounts= new ArrayList<>();

		try {

			if(!userName.isEmpty()) {

				user = userRepository.findByUserName(userName).orElseThrow(()->(new UsernameNotFoundException("User with :" + userName +" Not found")));

		//		log.info("User getAccountsSet Details : {}" , user.getAccountsSet());

				 accounts = user.getAccountsSet();

			}else {
				errorList.add("Please provide the User Name, Phone Number or Email to find the Customer Details !");
			}

		} catch (Exception e) {
			throw new AccountNotFoundException("No account found for this user");
		}

return accounts;
	}

	/**
	 * @param userName
	 * @param errorList
	 * @return
	 */
	@Override
	public UserDTO getUserDetails(String userName, List<String> errorList) {

		UserDTO userDTO = new UserDTO();

		try {
			if (!userName.isEmpty()){
				Users users = userRepository.findByUserName(userName).orElseThrow(()-> new UsernameNotFoundException("User with provided username is not found"));
				userDTO = UserMapper.mapToUsersDTO(users);
				userDTO.setDateOfBirth(Utils.convertToDateMonthYear(users.getDateOfBirth().toString()));

				log.info("User Creaeted" + userDTO +" :: User Date OF birth is  ::  "+ userDTO.getDateOfBirth());

			}else {
				errorList.add("Username cannot be empty! ");
			}
		} catch (UsernameNotFoundException e) {
			throw new RuntimeException(e);
		}
		return userDTO;
	}

	/**
	 * @param userName
	 * @return
	 */
	@Override
	public boolean deleteUserByUsername(String userName) {

		boolean isDeleted = false;
		Users user = userRepository.findByUserName(userName).orElseThrow(()-> new UsernameNotFoundException("User not found"));
				userRepository.delete(user);
				isDeleted=true;

		return isDeleted;
	}


}
