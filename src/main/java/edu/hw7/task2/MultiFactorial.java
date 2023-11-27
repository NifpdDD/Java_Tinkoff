package edu.hw7.task2;

import java.util.stream.LongStream;

public class MultiFactorial {
    private final int value;

    public MultiFactorial(int value) {
        checkValue(value);
        this.value = value;
    }

    private static void checkValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must be positive");
        }
    }

    public Long countFactorial() {
        return LongStream.range(1, value + 1).parallel().reduce(1L, (a, b) -> a * b);
    }
}
