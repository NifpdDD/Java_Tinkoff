package edu.hw1;

import java.util.Arrays;

public final class Task4 {

    public boolean isNestable(int[] a, int[] b) {

        if (a == null || b == null || a.length == 0 || b.length == 0) {
            throw new IllegalArgumentException("Один из массивов null или пустой ");
        } else {

            int minA = Arrays.stream(a).min().orElseThrow();
            int minB = Arrays.stream(b).min().orElseThrow();
            int maxA = Arrays.stream(a).max().orElseThrow();
            int maxB = Arrays.stream(b).max().orElseThrow();

            return minA > minB && maxA < maxB;
        }
    }
}
