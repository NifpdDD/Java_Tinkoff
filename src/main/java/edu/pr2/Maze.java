package edu.pr2;

public final class Maze {
    private final int height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private final int width;

    public Cell[][] getGrid() {
        return grid;
    }

    private final Cell[][] grid;


    public Maze(int height, int width, Cell[][] grid) {
        this.height = height;
        this.width = width;
        this.grid = grid;
    }

}
