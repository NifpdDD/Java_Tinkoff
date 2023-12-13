package edu.hw9.task3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DFSRecursiveTaskTest {
    @Test
    public void testDepthFirstSearch() {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.depthFirstSearch(0);

        Assertions.assertThat(graph.areAllVerticeVisited()).isTrue();
    }
}

