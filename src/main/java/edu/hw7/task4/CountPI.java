package edu.hw7.task4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class CountPI {
    private final int iters;

    public CountPI(int iters) {
        this.iters = iters;
    }

    @SuppressWarnings("MagicNumber")
    public double count() {
        int circleCount = 0;
        for (int i = 0; i < iters; i++) {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y < 1) {
                circleCount++;
            }
        }
        return 4 * ((double) circleCount / iters);
    }

    @SuppressWarnings("MagicNumber")
    public double countMultiThread(byte numberOfThread) throws InterruptedException, ExecutionException {
        int countInOneThread = iters / numberOfThread;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThread);
        Future<Integer>[] results = new Future[numberOfThread];

        for (int i = 0; i < numberOfThread; i++) {
            Callable<Integer> callable = getCallable(countInOneThread);
            results[i] = executor.submit(callable);
        }

        int circleCount = 0;
        int totalCount = 0;
        for (Future<Integer> result : results) {
            circleCount += result.get();
            totalCount += countInOneThread;
        }

        executor.shutdown();

        return 4 * ((double) circleCount / totalCount);
    }

    private Callable<Integer> getCallable(int countInOneThread) {
        return () -> {
            int circleCount = 0;
            for (int j = 0; j < countInOneThread; j++) {
                double x = ThreadLocalRandom.current().nextDouble(0.0, 1);
                double y = ThreadLocalRandom.current().nextDouble(0.0, 1);
                if (x * x + y * y < 1) {
                    circleCount++;
                }
            }
            return circleCount;
        };
    }

}
