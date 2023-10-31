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
        var expectedPath = new ArrayList<>(Arrays.asList(new ));
        var s = new MazeSolverBFS();

        var path = s.solve(maze,new Coordinate(1,1),new Coordinate(0,1));

        Assertions.assertThat(prettyMazePath).isEqualTo(stringMazePath);
    }
}
