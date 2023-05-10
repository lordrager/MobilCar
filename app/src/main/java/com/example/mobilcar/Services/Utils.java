package com.example.mobilcar.Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean isContainsOnlyLetters(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean isContainsOnlyNumbers(String name){
        return name.matches("[0-9]+");
    }


    //Check if password contains one digit at least one lowercase at least one uppercase one special character at least 8numbers
    public static boolean isStrongPassword(String name){
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
