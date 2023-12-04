package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client extends Thread {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String word;

    @Getter private String answer;

    public Client(String word) {
        this.word = word;
    }

    public void run() {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", Server.PORT))) {
            ByteBuffer buffer = ByteBuffer.allocate(Server.CAPACITY);

            buffer.clear();
            buffer.put(word.getBytes());
            buffer.flip();
            socketChannel.write(buffer);

            buffer.clear();
            socketChannel.read(buffer);
            buffer.flip();

            answer = word + ":" + new String(buffer.array(), 0, buffer.limit());
        } catch (IOException e) {
            LOGGER.error("IOException occurred", e);
        }
    }
}
