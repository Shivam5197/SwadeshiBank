package com.bank.SwadeshiBank.SecurityConfig;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    
	  private static final Logger log = LogManager.getLogger(CustomAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = exception.getMessage();
        // You can log the error message
        log.error("Authentication failed with message: " + errorMessage);

        // Redirect back to login page with error message
        getRedirectStrategy().sendRedirect(request, response, "/swadeshiBank/v1/login?error=" + errorMessage);
    }

}
