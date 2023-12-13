package edu.hw9.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Graph {
    private int vertices;
    private boolean visited[];
    private List<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }
    public boolean areAllVerticeVisited()
    {
        for (var ver:visited){
            if (!ver)
                return false;
        }
        return true;
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    public void depthFirstSearch(int startVertex) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        try {
            forkJoinPool.invoke(new DFSRecursiveTask(startVertex, visited, adjacencyList));
        } finally {
            forkJoinPool.shutdown();
        }
    }
}
