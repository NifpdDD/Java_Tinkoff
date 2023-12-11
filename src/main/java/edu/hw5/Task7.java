package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {

    public static final Pattern PATTERN_IS_LENGTH_MORE_THAN_3_AND_3_POS_EQUALS_0 = Pattern.compile("[01]{2}0.*");
    public static final Pattern PATTERN_IS_BEGIN_AND_END_WITH_THE_SAME_CHAR = Pattern.compile("^([01]).*\\1$");
    public static final Pattern PATTERN_IS_LENGTH_BETWEEN_1_AND_3 = Pattern.compile("^[01]{1,3}$");

    public boolean isLegnthMoreThan3And3PosEquals0(String str) {
        return PATTERN_IS_LENGTH_MORE_THAN_3_AND_3_POS_EQUALS_0.matcher(str).find();
    }

    public boolean isBeginAndEndWithTheSameChar(String str) {
        return PATTERN_IS_BEGIN_AND_END_WITH_THE_SAME_CHAR.matcher(str).find();
    }

    public boolean isLengthBetween1and3(String str) {
        return PATTERN_IS_LENGTH_BETWEEN_1_AND_3.matcher(str).find();
    }

}
