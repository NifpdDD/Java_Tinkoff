package edu.hw1;

import java.util.Arrays;

public class Task7 {
    public Task7() {

    }

    private static final int FINAL_NUMBER = 6174;

    @SuppressWarnings("MagicNumber")
    public int countK(int n) {
        if (n == FINAL_NUMBER) {
            return 0;
        }
        if (String.valueOf(n).length() != 4 | n < 1001) {
            return -1;
        }
        int[] digits = new int[4];
        int number = n;
        for (int i = 0; i < 4; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        boolean allEqual = Arrays.stream(digits).allMatch(x -> x == digits[0]);
        int descending;
        int ascending;
        if (!allEqual) {
            Arrays.sort(digits);
            ascending = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
            descending = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];
        } else {
            return -1;
        }
        int difference = descending - ascending;
        if (difference < 1000) {
            difference *= 10;
        }
        return 1 + countK(difference);
    }
}
