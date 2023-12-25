package edu.hw1;

public class Task6 {

    public static String getNextDescendant(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i += 2) {
            int sum = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));
            sb.append(sum);
        }

        return sb.toString();
    }

    public boolean isPalindromeDescendant(int number) {
        String numberString = String.valueOf(number);
        while (numberString.length() > 1) {
            if (new StringBuilder(numberString).reverse().toString().equals(numberString)) {
                return true;
            }
            numberString = getNextDescendant(numberString + 0);
        }
        return false;
    }

}
