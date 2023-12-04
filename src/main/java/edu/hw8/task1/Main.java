package edu.hw8.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MILLIS = 1000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Server server = new Server();
        executorService.submit(server);
        sleep(MILLIS);

        Client client1 = new Client("оскорбления");
        executorService.submit(client1);

        Client client2 = new Client("личности");
        executorService.submit(client2);

        Client client3 = new Client("интеллект");
        executorService.submit(client3);

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
