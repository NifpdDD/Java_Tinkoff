package edu.hw1;

public final class Task3 {

    @SuppressWarnings("MagicNumber")
    public int countDigits(long a) {
        long number = a;
        int k = 0;
        if (number != 0) {
            while (number != 0) {
                number /= 10;
                k++;
            }
        } else {
            k = 1;
        }
        return k;
    }
}
