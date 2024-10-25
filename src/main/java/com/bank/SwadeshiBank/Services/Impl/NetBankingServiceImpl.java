package com.bank.SwadeshiBank.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.Entity.Accounts;
import com.bank.SwadeshiBank.Entity.NetBankingEntity;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Repository.AccountsRepository;
import com.bank.SwadeshiBank.Repository.NetBankingRepository;
import com.bank.SwadeshiBank.Repository.UsersRepository;
import com.bank.SwadeshiBank.Services.NetBankingService;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Transactional
@Service
public class NetBankingServiceImpl implements NetBankingService {


    @Autowired
    NetBankingRepository netBankingRepository;

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    UsersRepository usersRepository;

    /**
     * @param username
     * @param accountNumber
     * @param errorList
     * @return
     */
    @Override
    public NetBankingEntity generateNetBanking( String username, Long accountNumber, List<String> errorList) {
        boolean isNetBankingCreated = false;
        NetBankingEntity netBankingEntity = new NetBankingEntity();
        try {
            Accounts accounts = accountsRepository.findByAccountNumber(accountNumber);
            Users users = usersRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("Username is not found"));
            String NetPass = RandomStringGenerator.generateRandomAlphanumericSpecial(14);
            if(!username.isEmpty() || accountNumber !=null){

                netBankingEntity.setAccount(accounts);
                netBankingEntity.setUser(users);
                netBankingEntity.setIfscCode(accounts.getIfscCode());
                netBankingEntity.setAccountHolderName(users.getFullname());
                netBankingEntity.setUserName(users.getUserName());
                netBankingEntity.setPassword(new BCryptPasswordEncoder().encode(NetPass));
                netBankingEntity.setStatus(Constants.status.ACTIVE);
                netBankingRepository.save(netBankingEntity);
                netBankingEntity.setPassword(NetPass);
                isNetBankingCreated =true;

            }
        } catch (UsernameNotFoundException e) {
            errorList.add("FAiled to enable NetBanking ");
            throw new RuntimeException(e);
        }
        return netBankingEntity;
    }


}
