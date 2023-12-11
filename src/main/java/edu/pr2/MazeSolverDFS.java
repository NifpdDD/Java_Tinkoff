package edu.pr2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeSolverDFS extends Solver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        checkCoord(maze, start);
        checkCoord(maze, end);
        int width = maze.width();
        int height = maze.height();
        Cell[][] cells = maze.grid();

        boolean[][] visited = new boolean[height][width];
        List<Coordinate> path = new ArrayList<>();
        dfs(cells, start, end, visited, path);
        Collections.reverse(path);
        if (visited[end.row()][end.col()]) {
            return path;
        }
        return new ArrayList<>();
    }

    private void dfs(
        Cell[][] cells,
        Coordinate current,
        Coordinate end,
        boolean[][] visited,
        List<Coordinate> path
    ) {
        int x = current.col();
        int y = current.row();

        path.add(current);

        visited[y][x] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValidMove(cells, newX, newY) && !visited[newY][newX]) {
                Coordinate next = new Coordinate(newY, newX);
                if (current.equals(end)) {
                    return;
                }
                dfs(cells, next, end, visited, path);

            }
        }
    }

    private boolean isValidMove(Cell[][] cells, int x, int y) {
        return x >= 0 && x < cells[0].length && y >= 0 && y < cells.length && cells[y][x].type() == Cell.Type.PASSAGE;
    }
}

