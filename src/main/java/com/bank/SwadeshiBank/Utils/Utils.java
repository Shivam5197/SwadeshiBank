package com.bank.SwadeshiBank.Utils;

import com.bank.SwadeshiBank.DTO.APIResponseDTO;
import org.springframework.http.HttpStatus;

public class Utils {

    public APIResponseDTO getDefaultApiResponse() {
        APIResponseDTO apiResponseModel = null;
        try {
            apiResponseModel = new APIResponseDTO();
            apiResponseModel.setData(null);
            apiResponseModel.setMessage("Unable to process the request!");
            apiResponseModel.setStatus(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponseModel;
    }

    
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    // Check if a string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Check if a number (Integer) is null
    public static boolean isNull(Integer number) {
        return number == null;
    }

    // Check if a number (Long) is null
    public static boolean isNull(Long number) {
        return number == null;
    }

    // Check if a number (Double) is null
    public static boolean isNull(Double number) {
        return number == null;
    }
}
