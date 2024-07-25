package com.bank.SwadeshiBank.Services;


import java.util.List;

import com.bank.SwadeshiBank.DTO.NewAccountsDraftDTO;
import com.bank.SwadeshiBank.DTO.UserDTO;

public interface ManagerServices {

    NewAccountsDraftDTO getNewAccountsDto();

    Boolean verifyUserToOpenAccount(UserDTO user , List<String> errorList);

    List<NewAccountsDraftDTO> getListOfPendingAccounts(List<String> errorList);

    Boolean UserApproved (Integer draftId , List<String> errorList);

}
