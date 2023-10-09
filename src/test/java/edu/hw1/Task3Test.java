package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    public void ifPositiveNumber_ShouldReturnNumberOfDigits() {
        Task3 task3 = new Task3();
        int result = task3.countDigits(12345);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void ifZero_ShouldReturn1() {
        Task3 task3 = new Task3();
        int result = task3.countDigits(0);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifNegativeNumber_ShouldReturnNumberOfDigits() {
        Task3 task3 = new Task3();
        int result = task3.countDigits(-9876);
        Assertions.assertThat(result).isEqualTo(4);

    }
}
