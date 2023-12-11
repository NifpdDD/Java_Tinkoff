package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {

    public static final Pattern PATTERN_IS_LENGTH_IS_ODD = Pattern.compile("^([01][01])*[01]$");
    public static final Pattern PATTERN_IS_LENGTH_IS_ODD_AND_START_WITH_0_OR_LENGTH_IS_EVEN_AND_START_WITH_1 =
        Pattern.compile("^0([01][01])*$|^1[01]([01][01])*$");
    public static final Pattern PATTERN_IS_NUMBER_OF_MOD_3_EQUALS_0 = Pattern.compile("^(1*01*01*0)*[1]*$");
    public static final Pattern PATTERN_IS_NUMBER_IS_NOT_EQUAL_111_OR_11 = Pattern.compile("^(?!111$|11$)[01]*$");

    public boolean isLengthIsOdd(String str) {
        return PATTERN_IS_LENGTH_IS_ODD.matcher(str).find();
    }

    public boolean isLengthIsOddAndStartWith0OrLengthIsEvenAndStartWith1(String str) {
        return PATTERN_IS_LENGTH_IS_ODD_AND_START_WITH_0_OR_LENGTH_IS_EVEN_AND_START_WITH_1.matcher(str).find();
    }

    public boolean isNumberOf0mod3equals0(String str) {
        return PATTERN_IS_NUMBER_OF_MOD_3_EQUALS_0.matcher(str).find();
    }

    public boolean isNumberIsNotEqual111or11(String str) {
        return PATTERN_IS_NUMBER_IS_NOT_EQUAL_111_OR_11.matcher(str).find();
    }

}
