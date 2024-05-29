package com.bank.SwadeshiBank.Services.Impl;

import java.util.List;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.Entity.Authority;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Mapper.UserMapper;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Repository.UsersRepository;
import com.bank.SwadeshiBank.Services.AccountsService;
import com.bank.SwadeshiBank.Services.CardsService;
import com.bank.SwadeshiBank.Services.UsersService;
import com.bank.SwadeshiBank.Utils.Utils;

import jakarta.transaction.Transactional;
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


//	@Autowired
//	mailService


    @Override
    public UserDTO addNewUser(UserDTO userDto, List<String> errorList) {
        UserDTO createdUserDto = new UserDTO();
        Users userEntity = new Users();


        try {

            if (!Utils.isNull(userDto)) {
                userEntity = userRepository.findByMobileNumber(userDto.getMobileNumber());

                try {
                    if (!Utils.isNull(userEntity)) {
                        Users newUser = UserMapper.mapToUsersEntity(userDto, userEntity, errorList);

                        /*						creatingPasswordToShareWithUsers	*/
                        String password = "{bcrypt}" + RandomStringGenerator.generateRandomAlphanumericSpecial(10);
                        log.debug("Generated Password :- >{}", password);

                        userEntity.setPassword(new BCryptPasswordEncoder().encode(password));
                        log.debug("encoded Password :- >{}", userEntity.getPassword());
                        userEntity.setActive(Constants.UserActive.ACTIVE);
                        Authority authority = new Authority();
                        authority.setAuthority(Constants.Authority.USER);
                        userEntity.addAuthority(authority);

                        newUser = userRepository.save(newUser);

                        AccountsDTO accountsDTO = accountService.createAccount(newUser, null, errorList);


                    }
                } catch (Exception e) {
                    errorList.add("User with this mobile number already exists !");
                    throw new RuntimeException(e);
                }

            } else {
                errorList.add("Please provide required details!");
            }


        } catch (Exception e) {
            e.printStackTrace();
            errorList.add("Something Went wrong please try again ! ");
        }


        return null;
    }

}
