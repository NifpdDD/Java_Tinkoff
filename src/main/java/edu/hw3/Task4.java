package edu.hw3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Task4 {
    @SuppressWarnings("MagicNumber")
    public String convertToRoman(int number) {
        if (number <= 0 || number > 4000) {
            throw new IllegalArgumentException();
        }
        Map<Integer, String> romanNumerals = getRomanNumerals();
        int numberModify = number;
        StringBuilder romanNumber = new StringBuilder();

        for (var arabicValue : romanNumerals.keySet()) {
            String romanSymbol = romanNumerals.get(arabicValue);

            while (numberModify >= arabicValue) {
                romanNumber.append(romanSymbol);
                numberModify -= arabicValue;
            }
        }
        return romanNumber.toString();
    }

    @SuppressWarnings("MagicNumber")
    private static Map<Integer, String> getRomanNumerals() {
        Map<Integer, String> romanNumerals = new TreeMap<>(Comparator.reverseOrder());
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
        return romanNumerals;
    }
}
