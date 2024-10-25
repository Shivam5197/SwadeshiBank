package com.bank.SwadeshiBank.Mapper;

import com.bank.SwadeshiBank.DTO.UPIDTO;
import com.bank.SwadeshiBank.Entity.UPI_Entity;
import com.bank.SwadeshiBank.Utils.Utils;

import java.util.List;

public class UPIMapper {

    public static UPI_Entity mapToUPIEntity(UPIDTO upidto, List<String> errorList){
        UPI_Entity upiEntity = new UPI_Entity();
        if(!Utils.isNull(upidto)){
            upiEntity.setUPI_CODE(upidto.getUPI_CODE());
            upiEntity.setContactNumber(upidto.getContactNumber());
            upiEntity.setContactEmail(upidto.getContactEmail());
            upiEntity.setUser(upidto.getUser());
            upiEntity.setAccount(upidto.getAccount());
            upiEntity.setIfscCode(upidto.getIfscCode());
            upiEntity.setStatus(upidto.getStatus());
            upiEntity.setContactNumber(upidto.getContactNumber());

        }else{
            errorList.add("Nothing to Map");
        }
        return upiEntity;
    }

    public static UPIDTO mapToUPIDTO(UPI_Entity upiEntity, List<String> errorList){
        UPIDTO upidto = new UPIDTO();
        if(!Utils.isNull(upiEntity)){
            upidto.setUPI_CODE(upiEntity.getUPI_CODE());
            upidto.setContactNumber(upiEntity.getContactNumber());
            upidto.setContactEmail(upiEntity.getContactEmail());
            upidto.setUser(upiEntity.getUser());
            upidto.setAccount(upiEntity.getAccount());
            upidto.setIfscCode(upiEntity.getIfscCode());
            upidto.setStatus(upiEntity.getStatus());
            upidto.setContactNumber(upiEntity.getContactNumber());
        }else{
            errorList.add("Nothing to Map");
        }
        return upidto;
    }



}
