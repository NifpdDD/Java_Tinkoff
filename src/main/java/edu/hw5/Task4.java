package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    public boolean isPassword(String password) {
        var pattern = Pattern.compile("[~!@#$%^&*|]");
        return pattern.matcher(password).find();
    }

}
