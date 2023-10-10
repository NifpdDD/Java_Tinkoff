package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {
    @Test
    void if_0100_then_should_return_60_seconds() {
        Task2 task2 = new Task2();
        String time = "01:00";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(60);
    }

    @Test
    void if_1356_then_should_return_836_seconds() {
        Task2 task2 = new Task2();
        String time = "999:56";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(59996);
    }

    @Test
    void if_greater_than_or_equal_to_60_then_should_return_minus_1() {
        Task2 task2 = new Task2();
        String time = "10:60";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(-1);
    }

    @Test
    void if_negative_time_then_should_return_minus_1() {
        Task2 task2 = new Task2();
        String time = "-10:59";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(-1);
    }

    @Test
    void if_null_then_should_throw_null_pointer_exception() {
        Task2 task2 = new Task2();
        String time = null;
        Assertions.assertThatThrownBy(() -> task2.minutesToSeconds(time)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void if_does_not_match_the_format_mm_ss_then_should_return_minus_1() {
        Task2 task2 = new Task2();
        String time = "1111";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(-1);
    }
}
