package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task6Test {

    @Test
    void if_is_substr_should_return_true() {
        var str = "Hello world!";
        var task6 = new Task6();

        var substr = "world";

        Assertions.assertThat(task6.isSubstr(str, substr)).isTrue();
    }

    @Test
    void if_isnot_substr_should_return_true() {
        var str = "Hello world11!";
        var task6 = new Task6();

        var substr = "word";

        Assertions.assertThat(task6.isSubstr(str, substr)).isFalse();
    }
}
