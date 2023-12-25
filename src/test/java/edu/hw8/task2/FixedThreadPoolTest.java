package edu.hw8.task2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

class FixedThreadPoolTest {
    private static final long MOD = 1_000_000_007;

    private static long[][] matrixMultiply(long[][] A, long[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        long[][] result = new long[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return result;
    }

    private static long[][] matrixPower(long[][] matrix, int exponent) {
        if (exponent == 1) {
            return matrix;
        }

        if (exponent % 2 == 0) {
            long[][] halfPower = matrixPower(matrix, exponent / 2);
            return matrixMultiply(halfPower, halfPower);
        } else {
            long[][] halfPower = matrixPower(matrix, (exponent - 1) / 2);
            long[][] squared = matrixMultiply(halfPower, halfPower);
            return matrixMultiply(matrix, squared);
        }
    }

    private static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long[][] baseMatrix = {{1, 1}, {1, 0}};
        long[][] resultMatrix = matrixPower(baseMatrix, n - 1);

        return resultMatrix[0][0];
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
