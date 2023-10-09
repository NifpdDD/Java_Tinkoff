package edu.hw1;

public final class Task3 {
    public Task3() {

    }

    private static final int TEN = 10;

    public int countDigits(long a) {
        long number = a;
        int k = 0;
        if (number != 0) {
            while (number != 0) {
                number /= TEN;
                k++;
            }
        } else {
            k = 1;
        }
        return k;
    }
}
