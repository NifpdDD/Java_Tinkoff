package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    public boolean isRussianNumber(String number) {
        var pattern = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");
        return pattern.matcher(number).find();
    }
}
