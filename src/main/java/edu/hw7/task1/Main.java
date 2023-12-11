package edu.hw7.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final long ITERATIONS = 1000000L;

    private Main() {

    }

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int THREAD_COUNT = 12;

    public static void main(String[] args) {
        long iterations = ITERATIONS;

        long startTime1 = System.nanoTime();
        MulrtiInc mulrtiInc = new MulrtiInc();
        Thread[] threads1 = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads1[i] = new Thread(() -> {
                for (int j = 0; j < iterations / THREAD_COUNT; j++) {
                    mulrtiInc.inc();
                }
            });
            threads1[i].start();
        }
        for (Thread thread : threads1) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOGGER.error("InterruptedException occurred", e);
            }
        }
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;
        LOGGER.info("Time taken by MulrtiInc with {} threads: {} nanoseconds", THREAD_COUNT, duration1);

        long startTime2 = System.nanoTime();
        SingleInc singleInc = new SingleInc();
        for (int i = 0; i < iterations; i++) {
            singleInc.inc();
        }
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        LOGGER.info("Time taken by SingleInc: {} nanoseconds", duration2);

        if (duration1 < duration2) {
            LOGGER.info("MulrtiInc is faster");
        } else if (duration1 > duration2) {
            LOGGER.info("SingleInc is faster");
        } else {
            LOGGER.info("Both have similar performance");
        }
    }
}
