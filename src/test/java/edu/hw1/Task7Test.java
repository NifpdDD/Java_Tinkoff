package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task7Test {

    @Test
    public void if6174_ShouldReturn0() {
        Task7 task7 = new Task7();
        int n = 6174;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void ifNegativeNumber_ShouldReturnMinus1() {
        Task7 task7 = new Task7();
        int n = -111;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    public void if1000_ShouldReturnMinus1() {
        Task7 task7 = new Task7();
        int n = 1000;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    public void if1234_ShouldReturn3() {
        Task7 task7 = new Task7();
        int n = 1234;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void if2223_ShouldReturn3() {
        Task7 task7 = new Task7();
        int n = 2223;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void ifAllDigitsAreEqual_ShouldReturnMinus1() {
        Task7 task7 = new Task7();
        int n = 9999;
        int result = task7.countK(n);
        Assertions.assertThat(result).isEqualTo(-1);
    }
}
