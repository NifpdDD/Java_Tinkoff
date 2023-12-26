package edu.hw5;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class Task6 {
    @NotNull private static Pattern getPattern(String substr) {
        return Pattern.compile(".*" + substr + ".*");
    }

    public boolean isSubstr(String str, String substr) {
        var pattern = getPattern(substr);
        return pattern.matcher(str).find();
    }
}
