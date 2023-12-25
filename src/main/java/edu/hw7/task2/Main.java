package edu.hw7.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final int VALUE_FACT = 25;
    private static final Logger LOGGER = LogManager.getLogger();

    private Main() {

    }

    public static void main(String[] args) {
        int value = VALUE_FACT;

        long startTimeMulti = System.nanoTime();
        MultiFactorial multiFactorial = new MultiFactorial(value);
        long resultMulti = multiFactorial.countFactorial();
        long endTimeMulti = System.nanoTime();
        long durationMulti = endTimeMulti - startTimeMulti;
        LOGGER.info("Result {}.Time taken by MultiFactorial: {} nanoseconds", resultMulti, durationMulti);

        long startTimeSingle = System.nanoTime();
        SingleFactorial singleFactorial = new SingleFactorial((long) value);
        long resultSingle = singleFactorial.countFactorial();
        long endTimeSingle = System.nanoTime();
        long durationSingle = endTimeSingle - startTimeSingle;
        LOGGER.info("Result {}.Time taken by SingleFactorial: {} nanoseconds", resultSingle, durationSingle);

        if (durationMulti < durationSingle) {
            LOGGER.info("MultiFactorial is faster");
        } else if (durationMulti > durationSingle) {
            LOGGER.info("SingleFactorial is faster");
        } else {
            LOGGER.info("Both have similar performance");
        }
    }
}
