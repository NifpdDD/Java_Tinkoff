package edu.pr2;

import java.util.List;

public class Renderer {

    String[][] render(Maze maze) {
        String[][] prettyMaze = new String[maze.height()][maze.width()];
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                if (maze.grid()[i][j].type() == Cell.Type.WALL) {
                    prettyMaze[i][j] = "█";
                } else {
                    prettyMaze[i][j] = " ";
                }
            }
        }
        return prettyMaze;

    }

    String[][] render(Maze maze, List<Coordinate> path) {
        if (path.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[][] prettyMaze = new String[maze.height()][maze.width()];
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                if (maze.grid()[i][j].type() == Cell.Type.WALL) {
                    prettyMaze[i][j] = "█";
                } else if (path.contains(new Coordinate(i, j))) {
                    prettyMaze[i][j] = "*";
                } else {
                    prettyMaze[i][j] = " ";
                }
            }
        }
        return prettyMaze;
    }
}

