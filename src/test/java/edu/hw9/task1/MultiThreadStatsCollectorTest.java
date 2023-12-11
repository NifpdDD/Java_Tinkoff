package edu.hw9.task1;

import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.CountDownLatch;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static java.lang.Thread.sleep;

class MultiThreadStatsCollectorTest {
    @Test
    void collectMultiThread() throws Exception {
        var statsCollector = new MultiThreadStatsCollector(4);
        var countDownLatch = new CountDownLatch(3);
        var expected = new Stats("first", 6, OptionalDouble.of(2), OptionalDouble.of(3), OptionalDouble.of(1));
        var expected2 = new Stats("second", 15, OptionalDouble.of(5), OptionalDouble.of(6), OptionalDouble.of(4));
        var expected3 = new Stats("third", 24, OptionalDouble.of(8), OptionalDouble.of(9), OptionalDouble.of(7));

        new Thread(() -> {
            statsCollector.collect("first", new double[] {1, 2, 3});
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            statsCollector.collect("second", new double[] {4, 5, 6});
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            statsCollector.collect("third", new double[] {7, 8, 9});
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();

        Assertions.assertThat(statsCollector.getStats()).contains(expected, expected2, expected3);
        statsCollector.close();
    }

}
