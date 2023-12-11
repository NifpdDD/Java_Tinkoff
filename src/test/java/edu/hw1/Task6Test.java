package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task6Test {

    @Test
    @DisplayName("1221")
    void if_palindrome_number_1221_should_return_true() {
        Task6 task6 = new Task6();
        int number = 1221;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("112 -> 22")
    void if_palindrome_number_112_should_return_true() {
        Task6 task6 = new Task6();
        int number = 112;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("78411 -> 1551")
    void if_palindrome_number_78411_should_return_true() {
        Task6 task6 = new Task6();
        int number = 78411;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("11211230 -> 2333 -> 56 -> 11")
    void if_palindrome_number_11211230_should_return_true() {
        Task6 task6 = new Task6();
        int number = 11211230;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("1234 -> 37")
    void if_non_palindrome_number_should_return_false() {
        Task6 task6 = new Task6();
        int number = 1234;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    void if_single_digit_number_should_return_false() {
        Task6 task6 = new Task6();
        int number = 5;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    void if_negative_number_should_return_false() {
        Task6 task6 = new Task6();
        int number = -1221;
        boolean result = task6.isPalindromeDescendant(number);
        Assertions.assertThat(result).isEqualTo(false);
    }
}
