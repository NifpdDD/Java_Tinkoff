package edu.pr2;

import java.util.List;

public abstract class Solver {
    static void checkCoord(Maze maze, Coordinate coordinate) {
        if (coordinate.row() > maze.height() - 1 || coordinate.row() < 0 || coordinate.col() > maze.width() - 1
            || coordinate.col() < 0) {
            throw new IllegalArgumentException();
        }
    }

    abstract List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);
}
