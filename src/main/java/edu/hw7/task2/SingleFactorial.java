package edu.hw7.task2;

import java.util.stream.LongStream;

public class SingleFactorial {
    private final Long value;

    public SingleFactorial(Long value) {
        checkValue(value);
        this.value = value;
    }

    private static void checkValue(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must be positive");
        }
    }

    public Long countFactorial() {
        return LongStream.range(1, value + 1).reduce(1L, (a, b) -> a * b);
    }
}
