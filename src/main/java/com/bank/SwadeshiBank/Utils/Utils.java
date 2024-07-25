package com.bank.SwadeshiBank.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.bank.SwadeshiBank.DTO.APIResponseDTO;

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
    
    public static String getCurrentUsername() {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        }
    	
    	return null;
    }
    
}
