package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task9Test {
    @Test
    @DisplayName("На доске нет коней")
    public void ifValidBoardNoHorse_ShouldReturnTrue() {
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
    public void ifInvalidBoardSize_ShouldThrowException() {
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
    public void ifValidBoardIncorrectPos_ShouldReturnFalse() {
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
    public void ifValidBoardСorrectPos_ShouldReturnFalse() {
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
    public void ifEmptyBoard_ShouldThrowIllegalArgumentException() {
        Task9 task9 = new Task9();
        int[][] invalidBoard = {};
        Assertions.assertThatThrownBy(() -> task9.knightBoardCapture(invalidBoard))
            .isInstanceOf( IllegalArgumentException.class);;
    }

    @Test
    public void ifNullBoard_ShouldThrowIllegalArgumentException() {
        Task9 task9 = new Task9();
        int[][] invalidBoard = null;
        Assertions.assertThatThrownBy(() -> task9.knightBoardCapture(invalidBoard))
            .isInstanceOf( IllegalArgumentException.class);;
    }


    @Test
    public void ifInvalidValue_ShouldThrowException() {
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
