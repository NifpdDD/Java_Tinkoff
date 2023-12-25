package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task3Test {

    @Test
    void if_positive_number_should_return_number_of_digits() {
        Task3 task3 = new Task3();
        int result = task3.countDigits(12345);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void if_zero_should_return_1() {
        Task3 task3 = new Task3();
        int result = task3.countDigits(0);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void if_negative_number_should_return_number_of_digits() {
        Task3 task3 = new Task3();
        int result = task3.countDigits(-9876);
        Assertions.assertThat(result).isEqualTo(4);
    }
}
