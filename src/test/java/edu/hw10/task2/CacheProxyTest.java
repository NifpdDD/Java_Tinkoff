package edu.hw10.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static java.lang.Thread.sleep;

class CacheProxyTest {
    @Test
    void should_invoke_method(@TempDir Path tempDir) throws IOException {
        var fibCalc = new FibCalculatorVersion1();
        String expectedContent = "10:55";
        Path resolve = tempDir.resolve("fib.txt");

        FibCalculator fibCache = CacheProxy.create(fibCalc, FibCalculator.class, tempDir.toString());
        fibCache.fib(10);

        Assertions.assertThat(resolve.toFile()).exists();
        List<String> lines = Files.readAllLines(resolve);
        Assertions.assertThat(lines).containsExactly(expectedContent);
    }

    @Test
    void should_invoke_method_concurrently(@TempDir Path tempDir) throws InterruptedException, IOException {
        var fibCalc = new FibCalculatorVersion1();
        Path cache = tempDir;
        FibCalculator fibCache = CacheProxy.create(fibCalc, FibCalculator.class, cache.toString());
        String expectedContent = "10:55";
        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.execute(() -> {
                try {
                    fibCache.fib(10);
                    latch.countDown();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        latch.await();
        sleep(1000);
        executorService.shutdown();
        Path filePath = cache.resolve("fib.txt");
        Assertions.assertThat(Files.exists(filePath)).isTrue();
        List<String> lines = Files.readAllLines(filePath);
        Assertions.assertThat(lines).containsExactly(expectedContent);
    }

}
