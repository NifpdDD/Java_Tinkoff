package edu.pr2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MazeTest {
    @Test
    void if_not_correct_arg_should_return_e() {
        var h = -1;
        var w = -5;

        Assertions.assertThatThrownBy(() -> new Maze(-1, 5, null)).isInstanceOf(IllegalArgumentException.class);
    }
}
