package edu.pr2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator implements Generator {
    protected static final int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private final Random random = new Random();

    public MazeGenerator(Maze maze) {
        this.width = maze.width();
        this.height = maze.height();
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(Cell.Type.WALL);
            }
        }
    }

    @Override
    public Maze generate() {
        Stack<int[]> stack = new Stack<>();
        int y = 1;
        int x = 1;
        stack.push(new int[] {x, y});
        cells[y][x] = new Cell(Cell.Type.PASSAGE);

        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            x = current[0];
            y = current[1];
            int[] randomNeighbor = isHasUnvisitedNeighbor(height, width, x, y);
            if (randomNeighbor != null) {
                int newX = x + randomNeighbor[0] * 2;
                int newY = y + randomNeighbor[1] * 2;
                cells[newY][newX] = new Cell(Cell.Type.PASSAGE);
                cells[y + randomNeighbor[1]][x + randomNeighbor[0]] = new Cell(Cell.Type.PASSAGE);
                stack.push(new int[] {newX, newY});
            } else {
                stack.pop();
            }
        }

        return new Maze(height, width, cells);
    }

    private int[] isHasUnvisitedNeighbor(int height, int width, int x, int y) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] dir : MazeGenerator.DIRECTIONS) {
            int newX = x + dir[0] * 2;
            int newY = y + dir[1] * 2;

            if (newX >= 1 && newX < width - 1 && newY >= 1 && newY < height - 1
                && cells[newY][newX].type() == Cell.Type.WALL) {
                list.add(dir);
            }
        }
        int[] randomNeighbor = null;
        if (!list.isEmpty()) {
            randomNeighbor = list.get(random.nextInt(list.size()));
        }
        return randomNeighbor;
    }

}
