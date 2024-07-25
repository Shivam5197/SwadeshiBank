package com.bank.SwadeshiBank.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.bank.SwadeshiBank.Services.UsersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.DTO.NewAccountsDraftDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;
import com.bank.SwadeshiBank.Entity.Authority;
import com.bank.SwadeshiBank.Entity.NewAccountsDrafts;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Mapper.NewAccountsMapper;
import com.bank.SwadeshiBank.Repository.NewAccountsDraftRepository;
import com.bank.SwadeshiBank.Repository.UsersRepository;
import com.bank.SwadeshiBank.Services.ManagerServices;
import com.bank.SwadeshiBank.Utils.Utils;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class ManagerServicesImpl implements ManagerServices {

    private static final Logger log = LogManager.getLogger(ManagerServicesImpl.class);


    @Autowired
    NewAccountsDraftRepository newAccountsDraftRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    UsersRepository usersRepository;

    /**
     * @return
     */
    @Override
    public NewAccountsDraftDTO getNewAccountsDto() {
        return null;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Boolean verifyUserToOpenAccount(UserDTO userDto , List<String> errorList) {
        boolean AddedToVerificationList = false;
        try {
        if (!Utils.isNull(userDto.getMobileNumber()) & !Utils.isNull(userDto.getAadharNumber())
                & !Utils.isNull(userDto.getPanNumber())
                & !Utils.isNull(userDto.getUserName())
                & !Utils.isNull(userDto.getEmail())) {

         NewAccountsDraftDTO newAccountsDraftDTO =  NewAccountsMapper.mapUserDtoToNewAccountsDraftDTO(userDto);

//            NewAccountsMapper.mapToNewAccountsDraftsEntity(newAccountsDraftDTO);

           NewAccountsDrafts newAccountsDrafts = newAccountsDraftRepository.save(NewAccountsMapper.mapToNewAccountsDraftsEntity(newAccountsDraftDTO));
            AddedToVerificationList = true;

        }else {
            errorList.add("Please Provide all the Required Details! Application is Rejected !");
        }
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("Something Went Wrong! ");
        }
        return AddedToVerificationList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NewAccountsDraftDTO> getListOfPendingAccounts(List<String> errorList) {
        String username = Utils.getCurrentUsername();
        List<NewAccountsDraftDTO> newAccountsDraftDTO = new ArrayList<>();

        try {
            Users loggedInUser = usersRepository.findByUserName(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with this username!"));

            List<NewAccountsDrafts> newAccountsDrafts = newAccountsDraftRepository.findByCity(loggedInUser.getCity())
                    .orElseThrow(() -> new NoSuchElementException("No New Request found for :" + loggedInUser.getFullname() + " To be approved"));

            if (!newAccountsDrafts.isEmpty()) {
                for (NewAccountsDrafts newAccountsDrafts1 : newAccountsDrafts) {
                    newAccountsDraftDTO.add(NewAccountsMapper.mapToNewAccountsDraftsDTO(newAccountsDrafts1));
                }

                for (Authority authority : loggedInUser.getAuthorities()) {
                    if (authority.getAuthority().equals(Constants.Authority.MANAGER)) {
                        return newAccountsDraftDTO;
                    } else {
                        errorList.add("Permissions denied");
                    }
                }
            } else {
                errorList.add("Nothing Found!");
            }
        } catch (UsernameNotFoundException e) {
            errorList.add("Something Went Wrong !");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            errorList.add("Something Went Wrong !");
            e.printStackTrace();
        }
        return newAccountsDraftDTO;
    }

    /**
     * @param draftId
     * @param errorList
     * @return
     */
    @Override
    public Boolean UserApproved(Integer draftId, List<String> errorList) {

        boolean isSaved = false;
        UserDTO userDTO = new UserDTO();
        NewAccountsDrafts newAccountsDrafts = new NewAccountsDrafts();

        try {
           newAccountsDrafts = newAccountsDraftRepository.findById(draftId).orElseThrow(()->
                   new UsernameNotFoundException("User Not found!"));

          NewAccountsDraftDTO newAccountsDraftDTO = NewAccountsMapper.mapToNewAccountsDraftsDTO(newAccountsDrafts);

          userDTO = NewAccountsMapper.mapToUsersDTO(newAccountsDraftDTO);

            isSaved = usersService.addNewUser(userDTO,errorList);

            if(isSaved) {
                
            	newAccountsDraftRepository.deleteById(draftId);
            	return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
