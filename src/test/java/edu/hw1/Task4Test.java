package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task4Test {
    @Test
    void if_nested_arrays_should_return_true() {
        Task4 task4 = new Task4();
        int[] a = {1, 2, 3, 4};
        int[] b = {0, 6};
        boolean result = task4.isNestable(a, b);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void if_invalid_arrays_should_throw_illegal_argument_exception() {
        Task4 task4 = new Task4();
        int[] a = {};
        int[] b = {4, 5, 6};
        Assertions.assertThatThrownBy(() -> task4.isNestable(a, b)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void if_not_nested_arrays_should_return_false() {
        Task4 task4 = new Task4();
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 3};
        boolean result = task4.isNestable(a, b);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void if_null_arrays_should_throw_illegal_argument_exception() {
        Task4 task4 = new Task4();
        int[] a = null;
        int[] b = {1,2,3};
        Assertions.assertThatThrownBy(() -> task4.isNestable(a, b)).isInstanceOf(IllegalArgumentException.class);
    }
}
