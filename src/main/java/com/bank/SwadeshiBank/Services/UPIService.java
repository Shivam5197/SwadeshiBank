package com.bank.SwadeshiBank.Services;

import java.util.List;

import com.bank.SwadeshiBank.DTO.UPIDTO;

public interface UPIService {

    boolean generateUPIId(UPIDTO upidto , String username, Long accountNumber, List<String> errorList);
}
