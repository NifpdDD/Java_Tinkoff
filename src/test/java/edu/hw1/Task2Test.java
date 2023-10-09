package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    void if0100Then_ShouldReturn60Seconds() {
        Task2 task2 = new Task2();
        String time = "01:00";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(60);
    }

    @Test
    void if1356Then_ShouldReturn836Seconds() {
        Task2 task2 = new Task2();
        String time = "999:56";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(59996);
    }

    @Test
    void ifGreaterThanOrEqualTo60_ShouldReturnMinus1() {
        Task2 task2 = new Task2();
        String time = "10:60";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(-1);
    }

    @Test
    void ifNegativeTime_ShouldReturnMinus1() {
        Task2 task2 = new Task2();
        String time = "-10:59";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(-1);
    }

    @Test
    void ifNull_ShouldThrowNullPointerException() {
        Task2 task2 = new Task2();
        String time = null;
        Assertions.assertThatThrownBy(() -> {
            task2.minutesToSeconds(time);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void ifDoesNotMatchTheFormatMmSs_ShouldReturnMinus1() {
        Task2 task2 = new Task2();
        String time = "1111";
        int response = task2.minutesToSeconds(time);
        Assertions.assertThat(response).isEqualTo(-1);
    }
}
