package edu.pr2;

import java.util.Random;

public class MazeGeneratorDFS implements Generator {
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private final Random random = new Random();
    protected static final int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public MazeGeneratorDFS(Maze maze) {
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
        dfs(1, 1);
        return new Maze(height, width, cells);
    }

    private void dfs(int x, int y) {
        cells[y][x] = new Cell(Cell.Type.PASSAGE);

        int[][] shuffledDirections = shuffleArray(DIRECTIONS);

        for (int[] dir : shuffledDirections) {
            int newX = x + dir[0] * 2;
            int newY = y + dir[1] * 2;

            if (newX > 0 && newX < width - 1 && newY > 0 && newY < height - 1
                && cells[newY][newX].type() == Cell.Type.WALL) {
                cells[y + dir[1]][x + dir[0]] = new Cell(Cell.Type.PASSAGE);
                dfs(newX, newY);
            }
        }
    }

    private int[][] shuffleArray(int[][] array) {
        int[][] shuffledArray = array.clone();
        for (int i = shuffledArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int[] temp = shuffledArray[index];
            shuffledArray[index] = shuffledArray[i];
            shuffledArray[i] = temp;
        }
        return shuffledArray;
    }
}
