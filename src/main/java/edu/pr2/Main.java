package edu.pr2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private Main() {

    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        var maze = new Maze(15, 15, null);
        Generator g = new MazeGeneratorDFS(maze);
        maze = g.generate();
        var solve = new MazeSolverDFS();
        var path = solve.solve(maze, new Coordinate(13, 1), new Coordinate(5, 2));
        var render = new Renderer();
        var prettyMaze = render.render(maze, path);

        for (String[] row : prettyMaze) {
            StringBuilder rowStringBuilder = new StringBuilder();
            for (String cell : row) {
                rowStringBuilder.append(cell);
            }
            String rowString = rowStringBuilder.toString();
            LOGGER.info(rowString);
        }
    }
}

