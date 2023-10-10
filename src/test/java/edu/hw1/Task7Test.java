package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task7Test {

    @Test
    void if_6174_should_return_0() {
        Task7 task7 = new Task7();
        int n = 6174;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void if_negative_number_should_return_minus_1() {
        Task7 task7 = new Task7();
        int n = -111;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    void if_1000_should_return_minus_1() {
        Task7 task7 = new Task7();
        int n = 1000;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    void if_1234_should_return_3() {
        Task7 task7 = new Task7();
        int n = 1234;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void if_2223_should_return_5() {
        Task7 task7 = new Task7();
        int n = 2223;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void if_all_digits_are_equal_should_return_minus_1() {
        Task7 task7 = new Task7();
        int n = 9999;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(-1);
    }
}
