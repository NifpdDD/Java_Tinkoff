package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends Thread {
    private static final Map<String, String> ANSWERS = Map.of(
        "личности", "Не переходи на личности там, где их нет",
        "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "интеллект", "Чем ниже интеллект, тем громче оскорбления"
    );

    public static final int PORT = 18080;
    public static final int N_THREADS = 5;
    public static final int CAPACITY = 1024;
    public static final String DEFAULT_VALUE = "Неизвестное слово";

    @Override
    public void run() {
        try {
            var selector = Selector.open();
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress("localhost", PORT));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            try (ExecutorService executor = Executors.newFixedThreadPool(N_THREADS)) {
                while (true) {
                    selector.select();
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectedKeys.iterator();

                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        if (key.isAcceptable()) {
                            register(selector, serverSocket);
                        }
                        if (key.isReadable()) {
                            SocketChannel client = (SocketChannel) key.channel();
                            getExecute(executor, client);
                        }
                        iter.remove();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getExecute(ExecutorService executor, SocketChannel client) {
        executor.execute(() -> {
            try {
                ByteBuffer buffer = ByteBuffer.allocate(CAPACITY);
                answer(buffer, client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void register(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel client = serverSocket.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private static void answer(ByteBuffer buffer, SocketChannel client) throws IOException {
        int bytesRead;

        try {
            bytesRead = client.read(buffer);
        } catch (IOException e) {
            client.close();
            return;
        }
        if (bytesRead == -1) {
            client.close();
        } else if (bytesRead > 0) {
            buffer.flip();
            String request = new String(buffer.array(), 0, bytesRead);
            String response = ANSWERS.getOrDefault(request, DEFAULT_VALUE);
            client.write(ByteBuffer.wrap(response.getBytes()));
            buffer.clear();
        }
    }



}
