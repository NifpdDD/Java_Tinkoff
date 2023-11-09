package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {
    public boolean isLengthIsOdd(String str) {
        var patten = Pattern.compile("^[01]*[01]$");
        return patten.matcher(str).find();
    }

    public boolean isLengthIsOddAndStartWith0OrLengthIsEvenAndStartWith1(String str) {
        var patten = Pattern.compile("^0[01]*$|^1[01]*[01]$");
        return patten.matcher(str).find();
    }

    public boolean isNumberOf0mod3equals0(String str) {
        var patten = Pattern.compile("(1*01*01*0)*+$");
        return patten.matcher(str).find();
    }

    public boolean isNumberIsNotEqual111or11(String str) {
        var patten = Pattern.compile("(?!111$|11$)^[01]+$");
        return patten.matcher(str).find();
    }

}
