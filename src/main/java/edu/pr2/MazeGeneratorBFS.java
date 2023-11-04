package edu.pr2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MazeGeneratorBFS implements Generator {
    protected static final int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public MazeGeneratorBFS(Maze maze) {
        this.width = maze.width();
        this.height = maze.height();
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(Cell.Type.WALL);
            }
        }
    }

    @Override public Maze generate() {
        return bfs();
    }

    private Maze bfs() {
        int x = 1;
        int y = 1;
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(y, x));
        cells[y][x] = new Cell(Cell.Type.PASSAGE);
        while (!stack.isEmpty()) {
            var current = stack.peek();
            var randomNeighbors = isHasUnvisitedNeighbor(current.col(), current.row());
            if (!randomNeighbors.isEmpty()) {
                for (var randomNeighbor : randomNeighbors) {
                    int newX = current.col() + randomNeighbor[0] * 2;
                    int newY = current.row() + randomNeighbor[1] * 2;
                    if (newY < height - 1 && newX < width - 1) {
                        cells[newY][newX] = new Cell(Cell.Type.PASSAGE);
                    }
                    cells[current.row() + randomNeighbor[1]][current.col() + randomNeighbor[0]] =
                        new Cell(Cell.Type.PASSAGE);
                    stack.push(new Coordinate(newY, newX));
                }
            } else {
                stack.pop();
            }
        }

        return new Maze(height, width, cells);
    }

    private ArrayList<int[]> isHasUnvisitedNeighbor(int x, int y) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] dir : MazeGeneratorBFS.DIRECTIONS) {
            int newX = x + dir[0] * 2;
            int newY = y + dir[1] * 2;
            if (newX >= 1 && newX < width && newY >= 1 && newY < height
                && cells[newY][newX].type() == Cell.Type.WALL) {
                list.add(dir);
            }
        }
        Collections.shuffle(list);
        return list;
    }

}
