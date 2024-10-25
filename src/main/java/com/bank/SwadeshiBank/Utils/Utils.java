package com.bank.SwadeshiBank.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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

    public static String convertToDateMonthYear(String timestamp) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            Date date = inputFormat.parse(timestamp);
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String convertToDateMonthYearWithTime(String timestamp) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMMM-yyyy 'at' HH:mm:ss");
            Date date = inputFormat.parse(timestamp);
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatDateToDDMMYYYY(String dateString) {
        // Define the input format for LocalDate (only date component)
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Parse the date string to a LocalDate object
            LocalDate date = LocalDate.parse(dateString, inputFormatter);

            // Define the output format
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");

            // Format the date to the desired output format
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid date format: " + dateString, e);
        }
    }
}
