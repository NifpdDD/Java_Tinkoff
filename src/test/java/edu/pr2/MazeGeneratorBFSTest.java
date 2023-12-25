package edu.pr2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MazeGeneratorBFSTest {
    @Test
    void test_generate_all_cells_not_null() {
        var maze = new Maze(5, 5, null);
        var mazeGenerator = new MazeGeneratorBFS(maze);

        maze = mazeGenerator.generate();

        Assertions.assertThat(maze.grid()).isNotNull();
        Assertions.assertThat(maze.grid()[1]).contains(new Cell(Cell.Type.PASSAGE));
        Assertions.assertThat(maze.grid()[2]).contains(new Cell(Cell.Type.PASSAGE));
    }

}
