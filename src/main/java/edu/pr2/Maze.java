package edu.pr2;

public record Maze(int height, int width, Cell[][] grid) {

    public Maze {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
