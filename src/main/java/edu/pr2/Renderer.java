package edu.pr2;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Renderer {
    private final static Logger LOGGER = LogManager.getLogger();

    String[][] render(Maze maze) {
        String[][] prettyMaze = new String[maze.getHeight()][maze.getWidth()];
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].type() == Cell.Type.WALL) {
                    prettyMaze[i][j] = "█";
                } else {
                    prettyMaze[i][j] = " ";
                }
            }
        }
        return prettyMaze;

    }

    String[][] render(Maze maze, List<Coordinate> path) {
        if (path.isEmpty())
            throw new IllegalArgumentException();
        String[][] prettyMaze = new String[maze.getHeight()][maze.getWidth()];
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].type() == Cell.Type.WALL) {
                    prettyMaze[i][j] = "█";
                } else if (path.contains(new Coordinate(i, j))) {
                    prettyMaze[i][j] = "*"; //
                } else {
                    prettyMaze[i][j] = " ";
                }
            }
        }
        return prettyMaze;
    }
}

