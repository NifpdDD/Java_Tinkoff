package edu.pr2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RendererTest {

    @Test
    void if_get_maze_should_render() {
        Cell[][] cells =
            {{new Cell(Cell.Type.WALL), new Cell(Cell.Type.WALL)},
                {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE)}};
        var maze = new Maze(2, 2, cells);
        var stringMaze = new String[][] {{"█", "█",}, {"█", " ",}};
        var r = new Renderer();

        var prettyMaze = r.render(maze);

        Assertions.assertThat(prettyMaze).isEqualTo(stringMaze);
    }

    @Test
    void if_get_path_in_maze_should_render() {
        Cell[][] cells =
            {{new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE)},
                {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE)}};
        var maze = new Maze(2, 2, cells);
        var stringMazePath = new String[][] {{"█", "*",}, {"█", "*",}};
        var r = new Renderer();
        var s = new MazeSolverBFS();

        var path = s.solve(maze, new Coordinate(1, 1), new Coordinate(0, 1));
        var prettyMazePath = r.render(maze, path);

        Assertions.assertThat(prettyMazePath).isEqualTo(stringMazePath);
    }

    @Test
    void if_no_path_in_maze_should_e() {
        Cell[][] cells =
            {{new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE)},
                {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE)}};
        var maze = new Maze(2, 2, cells);
        var r = new Renderer();
        var s = new MazeSolverBFS();

        var path = s.solve(maze, new Coordinate(1, 1), new Coordinate(0, 0));

        Assertions.assertThatThrownBy(() -> r.render(maze, path)).isInstanceOf(IllegalArgumentException.class);
    }
}

