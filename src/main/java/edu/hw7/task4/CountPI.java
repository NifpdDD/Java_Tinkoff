package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;

public class CountPI {
    private int totalCount;
    private int curcleCount;
    private final int iters;

    public CountPI(int iters) {
        this.iters = iters;
    }

    public double count() {
        for (int i = 0; i < iters; i++) {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y < 1) {
                curcleCount++;
            }
            totalCount++;
        }
        return (double) (4 * curcleCount) / totalCount;
    }

    public double countMultiThread(byte numberOfTread) throws InterruptedException {
        int countInOneTread = iters / numberOfTread;
        Thread[] threads = new Thread[numberOfTread];
        for (int i = 0; i < numberOfTread; i++) {
            threads[i] = new Thread(getRunnable(countInOneTread));
        }
        for (int i = 0; i < numberOfTread; i++) {
            threads[i].start();
        }
        for (int i = 0; i < numberOfTread; i++) {
                threads[i].join();
        }
        return (double) (4 * curcleCount) / totalCount;
    }

    private Runnable getRunnable(int countInOneTread) {
        return () -> {
            for (int j = 0; j < countInOneTread; j++) {
                double x = ThreadLocalRandom.current().nextDouble(0, 1);
                double y = ThreadLocalRandom.current().nextDouble(0, 1);
                if (x * x + y * y < 1) {
                    curcleCount++;
                }
                totalCount++;
            }
        };
    }
}
