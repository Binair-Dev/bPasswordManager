package su.bnair.bpassword.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
	
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*_=+-/";

    public static String generatePassword(int length, boolean useUpperCase, boolean useNumbers, boolean useSpecialCharacters) {
        StringBuilder characters = new StringBuilder(LOWER_CASE);
        
        if (useUpperCase) {
            characters.append(UPPER_CASE);
        }
        
        if (useNumbers) {
            characters.append(NUMBERS);
        }
        
        if (useSpecialCharacters) {
            characters.append(SPECIAL_CHARACTERS);
        }
        
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        
        return password.toString();
    }
}