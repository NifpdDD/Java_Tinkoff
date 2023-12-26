package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int numberOfThreads;
    private final Thread[] threads;
    private final BlockingQueue<Runnable> queue;
    private volatile boolean isShutdown = false;

    public FixedThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.threads = new Thread[numberOfThreads];
        this.queue = new LinkedBlockingQueue<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                while (!isShutdown) {
                    try {
                        Runnable task = queue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (isShutdown) {
            throw new IllegalStateException();
        }
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() {
        isShutdown = true;
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
