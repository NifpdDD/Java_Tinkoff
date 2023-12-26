package edu.hw9.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Graph {
    private int vertices;
    private List<Integer>[] adjacencyList;
    private boolean[] visited;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public boolean areAllVerticeVisited() {
        for (var vertex : visited) {
            if (!vertex) {
                return false;
            }
        }
        return true;
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    public void depthFirstSearch(int startVertex) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        try {
            visited = new boolean[vertices];
            forkJoinPool.invoke(new DFSRecursiveTask(startVertex, visited, adjacencyList));
        } finally {
            forkJoinPool.shutdown();
        }
    }
}
