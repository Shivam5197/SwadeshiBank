package com.bank.SwadeshiBank.Services.Impl;

import java.util.List;

import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.UPIDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.UPI_Entity;
import com.bank.SwadeshiBank.Exceptions.AccountNotFoundException;
import com.bank.SwadeshiBank.Exceptions.IncorrectUPIDetails;
import com.bank.SwadeshiBank.Mapper.AccountsMapper;
import com.bank.SwadeshiBank.Mapper.UserMapper;
import com.bank.SwadeshiBank.Repository.UPIRepository;
import com.bank.SwadeshiBank.Services.AccountsService;
import com.bank.SwadeshiBank.Services.UPIService;
import com.bank.SwadeshiBank.Services.UsersService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UPIServiceImpl implements UPIService {
    /**
     * @param username
     * @param errorList
     * @return
     */

    @Autowired
    UPIRepository upiRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    AccountsService accountsService;

    @Override
    public boolean generateUPIId(UPIDTO upidto , String username, Long accountNumber, List<String> errorList) {
        boolean isUPICreated = false;
        UPI_Entity upiEntity = new UPI_Entity();
        try {

            if(!username.isEmpty() || accountNumber !=null){

//                UserDTO userDTO = usersService.getUserByUserName(username,errorList);
                AccountsDTO accountsDTO = accountsService.getAccountByAccountNumber(accountNumber,errorList);
                Users users = usersRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("Username not found !"));
                if(users !=null) {
                    upiEntity.setUpiId(users.getMobileNumber() + "@swd");
                    upiEntity.setUPI_CODE(new BCryptPasswordEncoder().encode(upidto.getUPI_CODE()));
                    upiEntity.setUser(users);
                    upiEntity.setAccount(AccountsMapper.mapToAccounts(accountsDTO));
                    upiEntity.setIfscCode(accountsDTO.getIfscCode());
                    upiEntity.setContactEmail(users.getEmail());
                    upiEntity.setContactNumber(users.getMobileNumber());

                    upiRepository.save(upiEntity);
                    isUPICreated = true;
                }
            }else {
                throw new AccountNotFoundException("Username or Account Number is Incorrect ! ");

            }
        }catch (Exception e){

            throw new IncorrectUPIDetails("The details provided for the UPI are incorrect! ");

        }



        return isUPICreated;


    }
}
