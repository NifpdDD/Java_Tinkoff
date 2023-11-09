package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    public boolean isLegnthMoreThan3And3PosEquals0(String str) {
        var patten = Pattern.compile("[01]{2}0.*");
        return patten.matcher(str).find();
    }

    public boolean isBeginAndEndWithTheSameChar(String str) {
        var patten = Pattern.compile("^([01]).*\\1$");
        return patten.matcher(str).find();
    }

    public boolean isLengthBetween1and3(String str) {
        var patten = Pattern.compile("^[01]{1,3}$");
        return patten.matcher(str).find();
    }

}
