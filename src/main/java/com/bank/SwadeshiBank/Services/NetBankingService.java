package com.bank.SwadeshiBank.Services;


import com.bank.SwadeshiBank.Entity.NetBankingEntity;

import java.util.List;

public interface NetBankingService {

    NetBankingEntity generateNetBanking(String username, Long accountNumber, List<String> errorList);


}
