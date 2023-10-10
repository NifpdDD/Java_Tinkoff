package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task8Test {
    @Test
    @DisplayName("(17, 2) -> 6")
    void if_rotate_left_17_should_return_2() {
        Task8 task8 = new Task8();
        int n = 17;
        int shift = 2;
        int result = task8.rotateLeft(n, shift);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void if_rotate_left_with_negative_shift_should_return_minus_1() {
        Task8 task8 = new Task8();
        int n = 10;
        int shift = -2;
        int result = task8.rotateLeft(n, shift);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("(10, 2) -> 10")
    void if_rotate_right_10_should_return_10() {
        Task8 task8 = new Task8();
        int n = 10;
        int shift = 2;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void if_rotate_right_with_negative_shift_should_return_minus_1() {
        Task8 task8 = new Task8();
        int n = 10;
        int shift = -2;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    void if_rotate_left_negative_number_should_return_minus_1() {
        Task8 task8 = new Task8();
        int n = -17;
        int shift = 2;
        int result = task8.rotateLeft(n, shift);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    void if_rotate_right_negative_number_should_return_minus_1() {
        Task8 task8 = new Task8();
        int n = -17;
        int shift = 2;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    void if_rotate_right_0_should_return_0() {
        Task8 task8 = new Task8();
        int n = 0;
        int shift = 50;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void if_rotate_left_0_should_return_0() {
        Task8 task8 = new Task8();
        int n = 0;
        int shift = 10000;
        int result = task8.rotateLeft(n, shift);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
