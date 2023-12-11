package edu.hw9.task1;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import lombok.Getter;

public class MultiThreadStatsCollector implements AutoCloseable {
    @Getter private Queue<Stats> stats = new LinkedBlockingQueue<>();
    private final ExecutorService executorService;

    public MultiThreadStatsCollector(int threadCount) {
        this.executorService = Executors.newFixedThreadPool(threadCount);
    }

    public void collect(String name, double[] values) {
        executorService.execute(() -> stats.add(
            new Stats(name, Arrays.stream(values).sum(),
                Arrays.stream(values).average(),
                Arrays.stream(values).max(),
                Arrays.stream(values).min()
            )));
    }

    @Override
    public void close() throws Exception {
        executorService.shutdown();
    }

}
