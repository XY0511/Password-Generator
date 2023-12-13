package com.password;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        new PasswordGeneratorGUI();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        
        System.out.print("Include uppercase letters? (Y/N): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("Y");
        
        System.out.print("Include lowercase letters? (Y/N): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("Y");
        
        System.out.print("Include numbers? (Y/N): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("Y");
        
        System.out.print("Include special characters? (Y/N): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("Y");
        
        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Password: " + password);
        
        scanner.close();
    }
    
    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                          boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
        
        String availableChars = "";
        
        if (includeUppercase) {
            availableChars += uppercaseLetters;
        }
        
        if (includeLowercase) {
            availableChars += lowercaseLetters;
        }
        
        if (includeNumbers) {
            availableChars += numbers;
        }
        
        if (includeSpecialChars) {
            availableChars += specialChars;
        }
        
        SecureRandom random = new SecureRandom();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(availableChars.length());
            password.append(availableChars.charAt(randomIndex));
        }
        
        return password.toString();
    }
}
