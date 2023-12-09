package edu.hw9.task1;

import edu.hw8.task2.FixedThreadPool;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

public class MultiThreadStatsCollector {
    private Queue<Stats> stats = new ConcurrentLinkedQueue<>();
    private int threadCount;
    private ExecutorService executorService;
    public MultiThreadStatsCollector(int threadCount){
        this.executorService = ExecutorService.newFixedThreadPool(threadCount);
    }

}
