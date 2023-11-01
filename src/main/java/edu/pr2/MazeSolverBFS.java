package edu.pr2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MazeSolverBFS implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        checkSolve(maze, start, end);
        int width = maze.width();
        int height = maze.height();
        Cell[][] cells = maze.grid();

        boolean[][] visited = new boolean[height][width];
        Coordinate[][] parent = new Coordinate[height][width];

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        visited[start.row()][start.col()] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (current.equals(end)) {
                return reconstructPath(parent, start, end);
            }

            for (var neighbor : getNeighbors(current, cells, visited)) {
                int x = neighbor.col();
                int y = neighbor.row();
                visited[y][x] = true;
                parent[y][x] = current;
                queue.add(neighbor);
            }

        }

        return new ArrayList<>();
    }

    private static void checkSolve(Maze maze, Coordinate start, Coordinate end) {
        if (start.row() < 0 || start.col() > maze.height() - 1 || end.row() < 0
            || start.col() > maze.width() - 1) {
            throw new IllegalArgumentException();
        }
    }

    private List<Coordinate> reconstructPath(Coordinate[][] parent, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = end;

        while (!current.equals(start)) {
            path.add(current);
            current = parent[current.row()][current.col()];
        }

        path.add(start);
        Collections.reverse(path);
        return path;
    }

    private List<Coordinate> getNeighbors(Coordinate coordinate, Cell[][] cells, boolean[][] visited) {
        List<Coordinate> neighbors = new ArrayList<>();
        int x = coordinate.col();
        int y = coordinate.row();

        if (x + 1 < cells[y].length && cells[y][x + 1].type() == Cell.Type.PASSAGE && !visited[y][x + 1]) {
            neighbors.add(new Coordinate(y, x + 1));
        }
        if (x - 1 >= 0 && cells[y][x - 1].type() == Cell.Type.PASSAGE && !visited[y][x - 1]) {
            neighbors.add(new Coordinate(y, x - 1));
        }
        if (y + 1 < cells.length && cells[y + 1][x].type() == Cell.Type.PASSAGE && !visited[y + 1][x]) {
            neighbors.add(new Coordinate(y + 1, x));
        }
        if (y - 1 >= 0 && cells[y - 1][x].type() == Cell.Type.PASSAGE && !visited[y - 1][x]) {
            neighbors.add(new Coordinate(y - 1, x));
        }

        return neighbors;
    }
}

