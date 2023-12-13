package edu.hw9.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

class DFSRecursiveTask extends RecursiveTask<Void> {
    private final int currentVertex;
    private final boolean[] visited;
    private final List<Integer>[] adjacencyList;

    DFSRecursiveTask(int currentVertex, boolean[] visited, List<Integer>[] adjacencyList) {
        this.currentVertex = currentVertex;
        this.visited = visited;
        this.adjacencyList = adjacencyList;
    }

    public boolean isVertexVisited(int vertex) {
        return visited[vertex];
    }

    @Override
    protected Void compute() {
        if (!visited[currentVertex]) {
            visited[currentVertex] = true;
        }

        List<DFSRecursiveTask> subtasks = new ArrayList<>();

        for (int neighbor : adjacencyList[currentVertex]) {
            if (!visited[neighbor]) {
                DFSRecursiveTask subtask = new DFSRecursiveTask(neighbor, visited, adjacencyList);
                subtasks.add(subtask);
                subtask.fork();
            }
        }

        for (DFSRecursiveTask subtask : subtasks) {
            subtask.join();
        }
      return null;
    }
}
