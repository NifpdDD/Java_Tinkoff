package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task9Test {
    @Test
    @DisplayName("На доске нет коней")
    public void if_valid_board_has_not_horse_should_return_true() {
        Task9 task9 = new Task9();
        int[][] validBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        Assertions.assertThat(task9.knightBoardCapture(validBoard)).isTrue();
    }

    @Test
    public void if_invalid_board_size_should_throw_exception() {
        Task9 task9 = new Task9();
        int[][] invalidBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        Assertions.assertThatThrownBy(() -> task9.knightBoardCapture(invalidBoard))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void if_valid_board_has_incorrectPos_should_return_false() {
        Task9 task9 = new Task9();
        int[][] invalidBoard = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        Assertions.assertThat(task9.knightBoardCapture(invalidBoard)).isFalse();
    }

    @Test
    public void if_valid_board_has_correct_pos_should_return_true() {
        Task9 task9 = new Task9();
        int[][] validBoard = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        Assertions.assertThat(task9.knightBoardCapture(validBoard)).isTrue();
    }
    @Test
    public void if_empty_board_should_throw_illegal_argument_exception() {
        Task9 task9 = new Task9();
        int[][] invalidBoard = {};
        Assertions.assertThatThrownBy(() -> task9.knightBoardCapture(invalidBoard))
            .isInstanceOf( IllegalArgumentException.class);
    }

    @Test
    public void if_null_board_should_throw_illegal_argument_exception() {
        Task9 task9 = new Task9();
        int[][] invalidBoard = null;
        Assertions.assertThatThrownBy(() -> task9.knightBoardCapture(invalidBoard))
            .isInstanceOf( IllegalArgumentException.class);
    }


    @Test
    public void if_invalid_value_should_throw_exception() {
        Task9 task9 = new Task9();
        int[][] invalidBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2}
        };
        Assertions.assertThatThrownBy(() -> task9.knightBoardCapture(invalidBoard))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
