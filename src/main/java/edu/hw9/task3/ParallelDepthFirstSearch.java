package edu.hw9.task3;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelDepthFirstSearch {
    private ParallelDepthFirstSearch() {

    }

    private static final int NUM_THREADS = 4;

    public static void parallelDepthFirstSearch(Node root) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            final Node node = stack.pop();

            executorService.submit(() -> {

                if (node.getChildren() != null) {
                    for (Node child : node.getChildren()) {
                        stack.push(child);
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
