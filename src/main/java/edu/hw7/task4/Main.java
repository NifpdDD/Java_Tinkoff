package edu.hw7.task4;

import java.util.concurrent.ExecutionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final int NANO = 1000000;
    protected static final int[] ITERATIONS = new int[] {10_000_000, 100_000_000, 1_000_000_000};
    protected static final byte[] THREAD_COUNTS = new byte[] {1, 2, 4, 6, 12};
    private static final Logger LOGGER = LogManager.getLogger();

    private Main() {

    }

    public static void main(String[] args) {

        for (int iters : ITERATIONS) {
            LOGGER.info("Iterations: {}", iters);
            for (var numThreads : THREAD_COUNTS) {
                long startTime = System.nanoTime();
                CountPI countPI = new CountPI(iters);
                try {
                    double result = countPI.countMultiThread(numThreads);
                    long endTime = System.nanoTime();
                    LOGGER.info(
                        "Threads: {}, Result: {}, Time: {} nano",
                        numThreads,
                        result,
                        (endTime - startTime) / NANO
                    );
                } catch (InterruptedException e) {
                    LOGGER.error("InterruptedException occurred", e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            LOGGER.info("------------------------------");
        }
    }
}
