package com.bank.SwadeshiBank.Utils;
import java.util.Random;

public class AddressGenerator {
    private static final String[] STATES = {
        "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
        "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir",
        "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra",
        "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha",
        "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana",
        "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"
    };
    
    private static final String[] CITIES = {
        "Mumbai", "Delhi", "Bangalore", "Hyderabad", "Ahmedabad", 
        "Chennai", "Kolkata", "Surat", "Pune", "Jaipur", 
        "Lucknow", "Kanpur", "Nagpur", "Visakhapatnam", "Indore", 
        "Thane", "Bhopal", "Patna", "Vadodara", "Ghaziabad", 
        "Ludhiana", "Agra", "Nashik", "Faridabad", "Meerut", 
        "Rajkot", "Kalyan-Dombivali", "Vasai-Virar", "Varanasi", "Srinagar"
    };
    
    private static final String[] PINCODES = {
        "110001", "110002", "110003", "110004", "110005",
        "110006", "110007", "110008", "110009", "110010",
        "400001", "400002", "400003", "400004", "400005",
        "400006", "400007", "400008", "400009", "400010",
        // Add more pin codes as needed
    };

    public static void main(String[] args) {
        String address = generateAddress();
        String state = generateState();
        String city = generateCity();
        String pincode = generatePincode();
        
        System.out.println("Address: " + address);
        System.out.println("State: " + state);
        System.out.println("City: " + city);
        System.out.println("Pincode: " + pincode);
    }

    public static String generateAddress() {
        Random random = new Random();
        return random.nextInt(1000) + " " + CITIES[random.nextInt(CITIES.length)] + ", " + STATES[random.nextInt(STATES.length)];
    }

    public static String generateState() {
        Random random = new Random();
        return STATES[random.nextInt(STATES.length)];
    }

    public static String generateCity() {
        Random random = new Random();
        return CITIES[random.nextInt(CITIES.length)];
    }

    public static String generatePincode() {
        Random random = new Random();
        return PINCODES[random.nextInt(PINCODES.length)];
    }
}