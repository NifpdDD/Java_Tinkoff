package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {

    public static final Pattern PATTERN = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");

    public boolean isRussianNumber(String number) {
        return PATTERN.matcher(number).find();
    }
}
