package edu.hw7.task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class MulrtiIncTest {

    public static final int INT = 1_000_000 ;
    public static byte THREAD_COUNT = 6;

    @Test
    void try_multithread_inc() throws InterruptedException {
        var countDownLatch = new CountDownLatch(THREAD_COUNT);
        var value = new MulrtiInc();

        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                for (int j = 0; j < INT; j++) {
                    value.inc();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();

        Assertions.assertThat(value.getValue().get()).isEqualTo(THREAD_COUNT * INT);
    }
}
