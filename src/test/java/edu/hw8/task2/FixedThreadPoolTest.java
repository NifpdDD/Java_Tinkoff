package edu.hw8.task2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

class FixedThreadPoolTest {
    private static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

    @Test
    public void shoud_return_correct_value() throws InterruptedException {
        var fixedThreadPool = new FixedThreadPool(5);
        var actualFibValof5 = 5;
        var actualFibValof6 = 8;
        var actualFibValof7 = 13;
        AtomicLong expectedFibValof5 = new AtomicLong();
        AtomicLong expectedFibValof6 = new AtomicLong();
        AtomicLong expectedFibValof7 = new AtomicLong();
        CountDownLatch latch = new CountDownLatch(1);

        fixedThreadPool.start();
        fixedThreadPool.execute(() -> {
            expectedFibValof5.set(calculateFibonacci(5));
            expectedFibValof6.set(calculateFibonacci(6));
            expectedFibValof7.set(calculateFibonacci(7));
            latch.countDown();
        });
        latch.await();
        fixedThreadPool.close();

        Assertions.assertThat(expectedFibValof5.get()).isEqualTo(actualFibValof5);
        Assertions.assertThat(expectedFibValof6.get()).isEqualTo(actualFibValof6);
        Assertions.assertThat(expectedFibValof7.get()).isEqualTo(actualFibValof7);
    }
}
