package edu.pr2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeGeneratorDFS implements Generator {
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private static final List<int[]> DIRECTIONS = new ArrayList<>();

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
        DIRECTIONS.add(new int[] {1, 0});
        DIRECTIONS.add(new int[] {-1, 0});
        DIRECTIONS.add(new int[] {0, 1});
        DIRECTIONS.add(new int[] {0, -1});
        dfs(1, 1);
        return new Maze(height, width, cells);
    }

    private void dfs(int x, int y) {
        cells[y][x] = new Cell(Cell.Type.PASSAGE);

        Collections.shuffle(DIRECTIONS);

        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0] * 2;
            int newY = y + dir[1] * 2;

            if (newX > 0 && newX < width - 1 && newY > 0 && newY < height - 1
                && cells[newY][newX].type() == Cell.Type.WALL) {
                cells[y + dir[1]][x + dir[0]] = new Cell(Cell.Type.PASSAGE);
                dfs(newX, newY);
            }
        }
    }
}
