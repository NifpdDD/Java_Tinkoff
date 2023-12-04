package edu.hw8.task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void should_return_correct_answer() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(3);

        Server server = new Server();
        executorService.submit(() -> {
            server.run();
            latch.countDown();
        });
        Client client1 = new Client("оскорбления");
        executorService.submit(() -> {
            client1.run();
            latch.countDown();
        });
        Client client2 = new Client("личности");
        executorService.submit(() -> {
            client2.run();
            latch.countDown();
        });
        Client client3 = new Client("интеллект");
        executorService.submit(() -> {
            client3.run();
            latch.countDown();
        });
        executorService.shutdown();
        latch.await();

        Assertions.assertThat(client3.getAnswer()).isEqualTo("интеллект:Чем ниже интеллект, тем громче оскорбления");
        Assertions.assertThat(client2.getAnswer()).isEqualTo("личности:Не переходи на личности там, где их нет");
        Assertions.assertThat(client1.getAnswer()).isEqualTo("оскорбления:Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");

    }

}
