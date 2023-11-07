package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    public boolean isSubstr(String str, String substr) {
        var pattern = Pattern.compile(substr);
        return pattern.matcher(str).find();
    }
}
