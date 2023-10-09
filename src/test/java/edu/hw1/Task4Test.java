package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @Test
    public void ifNestedArraysShouldReturnTrue() {
        Task4 task4 = new Task4();
        int[] a = {1, 2, 3, 4};
        int[] b = {0, 6};
        boolean result = task4.isNestable(a, b);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void ifInvalidArrays_ShouldThrowIllegalArgumentException() {
        Task4 task4 = new Task4();
        int[] a = {};
        int[] b = {4, 5, 6};
        Assertions.assertThatThrownBy(() -> {
            task4.isNestable(a, b);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ifNotNestedArrays_ShouldReturnTrue() {
        Task4 task4 = new Task4();
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 3};
        boolean result = task4.isNestable(a, b);
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    public void ifNullArrays_ShouldThrowIllegalArgumentException() {
        Task4 task4 = new Task4();
        int[] a = null;
        int[] b = {};
        Assertions.assertThatThrownBy(() -> {
            task4.isNestable(a, b);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
