package com.bank.SwadeshiBank.Constants;

public class Constants {

    public static class UserActive{
        public static final boolean ACTIVE = true;
        public static final boolean DEACTIVATED = false;
    }

    public static class AccountType{
        public static final String SAVINGS_ACCOUNT = "Savings Account";
        public static final String  CURRENT_ACCOUNT= "Current Account";
        public static final String  SALARY_ACCOUNT= "Salary Account";
        public static final String  NRI_ACCOUNT= "NRI Account";
        public static final String  RD_ACCOUNT= "Recurring Deposit (RD) Accounts";
        public static final String  FD_ACCOUNT= "Fixed Deposit (FD) Accounts";

    }

    public static class Authority{
        public static final String USER    = "ROLE_USER";
        public static final String  MANAGER= "ROLE_MANAGER";
        public static final String  ADMIN= "ROLE_ADMIN";
    }

    public static class Cards{
        public static final String CREDIT_CARD = "Credit Card";
        public static final String  DEBIT_CARD= "Debit Card";
    }
    
    public static class UserType{
        public static final Integer  ADMIN= 0;
    	public static final Integer   USER= 1;
        public static final Integer  MANAGER= 2;
    	
    }

    public static class Gender{
        public static final String  FEMALE= "Female";
    	public static final String MALE    = "Male";
    	
    }
}
