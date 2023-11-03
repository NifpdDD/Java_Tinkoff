package edu.pr2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MazeSolverBFSTest {

    @Test
    void if_path_exist_should_return_coord_path() {
        Cell[][] cells =
            {{new Cell(Cell.Type.PASSAGE), new Cell(Cell.Type.PASSAGE)},
                {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE)}};
        var maze = new Maze(2, 2, cells);
        var expectedPath =
            new ArrayList<>(Arrays.asList(new Coordinate(1, 1), new Coordinate(0, 1), new Coordinate(0, 0)));
        var solverBFS = new MazeSolverBFS();

        var path = solverBFS.solve(maze, new Coordinate(1, 1), new Coordinate(0, 0));

        Assertions.assertThat(path).isEqualTo(expectedPath);
    }

    @Test
    void if_path_not_exist_should_return_empty_list() {
        Cell[][] cells =
            {{new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE)},
                {new Cell(Cell.Type.WALL), new Cell(Cell.Type.PASSAGE)}};
        var maze = new Maze(2, 2, cells);
        var expectedPath = new ArrayList<>();
        var solverBFS = new MazeSolverBFS();

        var path = solverBFS.solve(maze, new Coordinate(1, 1), new Coordinate(0, 0));

        Assertions.assertThat(path).isEqualTo(expectedPath);
    }
}
