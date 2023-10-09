package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task6Test {

    @Test
    @DisplayName("1221")
    public void ifPalindromeNumber1221_ShouldReturnTrue() {
        Task6 task6 = new Task6();
        int number = 1221;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("112 -> 22")
    public void ifPalindromeNumber112_ShouldReturnTrue() {
        Task6 task6 = new Task6();
        int number = 112;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("78411 -> 1551")
    public void ifPalindromeNumber78411_ShouldReturnTrue() {
        Task6 task6 = new Task6();
        int number = 78411;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("11211230 -> 2333 -> 56 -> 11")
    public void ifPalindromeNumber11211230_ShouldReturnTrue() {
        Task6 task6 = new Task6();
        int number = 11211230;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("1234 -> 37")
    public void ifNonPalindromeNumber_ShouldReturnFalse() {
        Task6 task6 = new Task6();
        int number = 1234;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    public void ifSingleDigitNumber_ShouldReturnFalse() {
        Task6 task6 = new Task6();
        int number = 5;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    public void ifNegativeNumber_ShouldReturnFalse() {
        Task6 task6 = new Task6();
        int number = -1221;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(false);
    }
}

