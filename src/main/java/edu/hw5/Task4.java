package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {

    public static final Pattern PATTERN = Pattern.compile("[~!@#$%^&*|]");

    public boolean isPassword(String password) {
        return PATTERN.matcher(password).find();
    }

}
